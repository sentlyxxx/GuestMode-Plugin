# GuestModePlugin

A simple Bukkit plugin that allows players to join the server in a restricted "Guest Mode" with custom permissions. The plugin prevents players from performing various actions until they complete a registration form. It also provides a clickable link in the chat for registration.

## Features

- **Restricted Mode**: Players entering the server with the "guestmode.restriction" permission will have restricted actions.
- **Prevent Inventory Access**: Players cannot open their inventory or interact with items.
- **Prevent Item Pickup and Flight**: Players cannot pick up items or fly.
- **Clickable Registration Link**: Players will receive a message in chat with a clickable registration link.
- **Permissions Handling**: Players need the proper permission (`guestmode.restriction`) to be affected by this plugin.

## Requirements

- **Bukkit** or **Spigot** server (compatible with versions up to 1.20.x)
- Java 8 or higher

## Installation

1. Download the `.jar` file from the releases section.
2. Place the `.jar` file in your server's `plugins` directory.
3. Restart the server or use `/reload` to load the plugin.

## Configuration

The plugin does not have a configuration file yet, but you can set up permissions for the players.

## Permissions

- `guestmode.restriction`: This permission is required for a player to enter the restricted "Guest Mode". Players with this permission will have limited actions as described below.

## Plugin Behavior

### On Player Join
- When a player with the `guestmode.restriction` permission joins the server:
  - The player is placed in **Survival mode**.
  - The player’s inventory is cleared.
  - The player cannot pick up items.
  - The player cannot fly.
  - A message with a clickable registration link will be sent in the chat.

### On Player Interact
- Players in **Guest Mode** will not be able to interact with the world (e.g., open inventory, place blocks, etc.).

### On Player Drop Item
- Players cannot drop items while in **Guest Mode**.

### On Entity Damage
- Players cannot damage entities (e.g., mobs or other players) while in **Guest Mode**.

### Chat Registration Link
- Players in **Guest Mode** will see a message in chat with a clickable link prompting them to complete a registration form.

## Commands

Currently, no commands are implemented in this version of the plugin. Future versions may include commands for administrators to manage guest players.

## Compilation

If you want to build the plugin from source:

### Prerequisites

- Java 8 or higher.
- Apache Maven installed on your system.

### Steps to Build

1. Clone or download the repository.
2. Open a terminal and navigate to the project directory.
3. Run the following command to compile and package the plugin:

   ```bash
   mvn clean package
