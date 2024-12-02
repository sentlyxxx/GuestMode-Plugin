# GuestModePlugin

## Description

The **GuestModePlugin** is a Minecraft plugin that allows server administrators to manage "guest" players. These players are restricted from interacting with the world until they complete an online registration form. This plugin automatically puts new players in guest mode, shows a message with a registration link, and blocks their interactions with the world. The plugin ensures that returning players are not affected by guest mode.

## Features

- Automatically sets new players to "guest mode" on their first login.
- Sends a custom message with a registration link when they join the server.
- Prevents players in guest mode from interacting with the world (e.g., chatting, damaging entities, moving items).
- Allows players in guest mode to move but restricts all other interactions.
- Player state is saved to ensure that returning players are not affected by guest mode.
- Customizable registration URL and messages in the configuration.

## Commands

1. **/guestmode [player]**  
   Toggles the guest mode for a specific player. If the player has completed the registration, it disables guest mode.

   **Usage**:  
   `/guestmode [player]`  
   **Permission**: `guestmode.command`

2. **/guestmode**  
   Toggles the guest mode for the player who issues the command.

   **Usage**:  
   `/guestmode`  
   **Permission**: `guestmode.command`

## Permissions

- **guestmode.command**: Allows the player to toggle their own guest mode or another player's guest mode.
- **guestmode.bypass**: Allows players to bypass guest mode restrictions (for administrators and moderators).

## Configuration

The plugin allows you to configure certain aspects, including the registration URL and whether guest mode is enabled for new players.

### Example `config.yml`

```yaml
guest-mode-enabled: true
registration-url: "http://example.com/anketa"
players:
  # Players who complete the registration will have guest mode disabled.
  # Example:
  # 'player-uuid':
  #   guest-mode: false
