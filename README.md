# GuestModePlugin

## Description

The **GuestModePlugin** is a Minecraft plugin that allows server administrators to manage "guest" players. These players are restricted from interacting with the world until they complete an online registration form. This plugin automatically puts new players in guest mode, showing a message with a registration link, and blocks their interactions with the world.

## Features

- Automatically sets new players to "guest mode" on their first login.
- Sends a custom message with a registration link when they join the server.
- Prevents players in guest mode from interacting with the world (e.g., chatting, damaging entities, moving items).
- Allows players in guest mode to move but restricts all other interactions.
- Player state is saved to ensure that returning players are not affected.

## Installation

1. Download the `GuestModePlugin` jar file.
2. Place the jar file into the `plugins` directory of your Minecraft server.
3. Restart your server.

## Configuration

The plugin does not require any additional configuration out of the box, but you can customize messages and settings as needed in the `config.yml` file generated after the first server startup.

### Example `config.yml`

```yaml
guest-mode-enabled: true
players:
  # Players who complete the registration will have guest mode disabled.
  # Example:
  # 'player-uuid':
  #   guest-mode: false
