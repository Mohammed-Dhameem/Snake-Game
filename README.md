# 🐍 Snake Game

A classic Snake game built with JavaFX for Linux and Windows.

## 🛠️ Tech Stack
- **Java 21** (LTS)
- **JavaFX 21.0.1**
- **Maven**
- **Eclipse IDE**

## 📋 Prerequisites
- JDK 21 or higher
- Maven 3.8+

## 🚀 Running the Game

### Using Maven
mvn javafx:run

### In Eclipse
Right-click `pom.xml` → Run As → Maven build... → Goals: `javafx:run`

## 📁 Project Structure
Snake_Game/
├── src/
│ ├── game/ # Main application & game engine
│ ├── ui/ # UI components (GamePanel, etc.)
│ ├── model/ # Game logic (Snake, Food)
│ └── controller/ # Input handling
├── pom.xml
└── README.md

## 🎮 Controls (Coming Soon)
- Arrow Keys: Move snake
- Space: Pause/Resume
- R: Restart

## 💻 System Requirements

### For Running the Game
- Java 21 or higher (if using JAR)
- OR use bundled installer (no Java needed)

### Supported Platforms
- ✅ Windows 10/11
- ✅ Ubuntu 20.04+ / Linux
- ✅ macOS 11+

## 🏗️ Building from Source

### Clone Repository
git clone https://github.com/Mohammed-Dhameem/Snake-Game.git

cd Snake-Game

### Build and Run
mvn clean install
mvn javafx:run

## 👨‍💻 Author
**Mohammed Dhameem**
- GitHub: [@Mohammed-Dhameem](https://github.com/Mohammed-Dhameem)

## 📝 License
MIT License

## 🔧 Development Status
🚧 Work in Progress - Game logic implementation in progress!

## 🎯 Roadmap
- [x] Project setup with JavaFX and Maven
- [x] GitHub repository with SSH configuration
- [ ] Snake movement logic
- [ ] Food generation and collision
- [ ] Score tracking
- [ ] Game over and restart
- [ ] Sound effects
- [ ] High score system
- [ ] Bundled installers for Linux and Windows
