# Minetap 1.0 — Minecraft 1.5.2

![Minetap Logo](https://pbs.twimg.com/media/Gj4xekWXoAAgNb5?format=jpg&name=small)

**Minetap 1.0** is a custom client for Minecraft 1.5.2, developed in Java using the MCP (Mod Coder Pack) framework.

The project provides useful gameplay modifications while also serving as an educational experiment involving Java development, Minecraft modding and launcher automation.

## Features

- **Xray — KEY: X**  
  Allows players to see ore blocks through walls.

- **AutoSprint — KEY: F**  
  Automatically enables sprinting when the assigned key is pressed.

- **Fly — KEY: C**  
  Enables flight mode for the player.

## New Launcher Update

Minetap now includes a redesigned launcher that makes installation and startup considerably easier.

### What's new

- New graphical interface.
- Black, white and gray visual theme.
- Dedicated **Execute Minetap** button.
- Automatic startup of the modified Minecraft 1.5.2 client.
- Automatic detection of the required files.
- Java 8 included with the launcher package.
- No manual MCP path configuration required.
- Custom Minetap executable and window icon.
- Cleaner and simplified launcher code.
- Clear error messages when a required file is missing.

## Installation

### Recommended installation

1. Open the **Releases** section of this repository.
2. Download `Minetap-Definitivo.zip`.
3. Extract the complete ZIP file into a folder.
4. Keep all included files and folders in their original locations.
5. Run `Minetap.exe`.
6. Click **Execute Minetap**.


### Installation from source

For developers who want to work with the original source:

1. Download **MCP 7.51 for Minecraft 1.5.2**.
2. Configure MCP and run `decompile.bat`.
3. Copy the Minetap source files into the MCP `src` directory.
4. Make sure **JDK 8** is being used.
5. Recompile or start the project through MCP.

Example path:

```text
..\Desktop\mcp751\src