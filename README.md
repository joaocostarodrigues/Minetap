# Minetap 1.2 — Minecraft 1.5.2

![Minetap Logo](https://pbs.twimg.com/media/Gj4xekWXoAAgNb5?format=jpg&name=small)

**Minetap 1.2** is a custom client for Minecraft 1.5.2, developed in Java using the MCP (Mod Coder Pack) framework.

The project provides useful gameplay modifications while also serving as an educational experiment involving Java development, Minecraft modding, interface design and launcher automation.

## Features

### Xray — Default key: X

Allows players to see selected ore blocks through walls.

### AutoSprint — Default key: F

Automatically enables sprinting while the player moves forward.

### Fly — Default key: C

Enables flight mode and allows the player to move vertically using the jump and sneak controls.

Flight now includes landing protection, preventing fall damage during flight and until the player safely reaches the ground.

### FallDamege — Default key: V

Prevents the player from taking fall damage, regardless of the height.

When disabled, Minecraft's normal fall-damage mechanics are restored.

### CPS Counter

Displays the number of left mouse button clicks made during the last second.

The counter appears in the upper-left corner and can be enabled or disabled from the Minetap menu.

## Minetap In-Game Menu

Press **Insert** while playing to open or close the Minetap control panel.

The menu provides:

- Individual buttons for enabling and disabling modules.
- Current status of every feature.
- Custom key configuration.
- CPS counter control.
- Global Minetap on/off control.
- Compact black, gray and white interface.
- Automatic preference saving.

Press **Esc**, **Insert** or click **Close menu** to return to the game. The world is not paused while the menu is open.

## Custom Keybinds

Every gameplay module can have its shortcut changed directly from the in-game menu.

1. Press **Insert**.
2. Click the **KEY** button next to a module.
3. Press the new keyboard key.
4. Press **Backspace** to remove a shortcut.
5. Press **Esc** to cancel.

Custom shortcuts are saved automatically and remain configured after restarting the game.

## Normal Minecraft Mode

The menu includes a **MINETAP: ON/OFF** control.

When Minetap is disabled:

- Every active module is immediately turned off.
- Gameplay shortcuts are blocked.
- Xray, Fly, AutoSprint and FallDamege cannot be activated.
- The CPS counter is hidden.
- Minecraft can be played without Minetap's additional gameplay features.

The features become available again after Minetap is enabled.

## Minetap 1.2 Launcher Update

Minetap now includes a redesigned launcher that makes configuration and startup considerably easier.

### What's new

- New graphical interface inspired by the Minetap logo.
- Black, graphite, silver and white color palette.
- Integrated Minetap logo and mascot.
- Custom executable and window icon.
- Dedicated **Execute Minetap** button.
- Custom nickname field.
- Automatic nickname saving.
- Automatic startup of the modified Minecraft 1.5.2 client.
- Automatic detection of required files.
- Portable Java 8 included in the package.
- No manual MCP path configuration required.
- Clear status and error messages.
- Shortcut for opening launcher logs.
- Cleaner and simplified launcher code.

## Custom Nickname

The launcher allows the player to choose a nickname before starting the game.

Nickname requirements:

- Between 3 and 16 characters.
- Letters, numbers and underscores are accepted.
- The last nickname is saved in `nickname.txt`.
- The nickname can be changed before any new game session.

> The nickname field does not authenticate or replace an official Microsoft or Mojang account.

## Installation

### Recommended Installation

1. Open the **Releases** section of this repository.
2. Download `Minetap-Definitivo.zip`.
3. Extract the complete ZIP file into a new folder.
4. Keep all included files and folders in their original locations.
5. Run `Minetap.exe`.
6. Enter your preferred nickname.
7. Click **Execute Minetap**.

> Do not run the launcher from inside the ZIP file. Extract the complete package first.

## Package Structure

```text
Minetap-Definitivo/
├── Minetap.exe
├── MinetapCore.exe
├── jdk8/
├── source/
└── LEIA-ME.txt