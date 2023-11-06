# File Organizer
Organize your files into folders by year and month faster with one simple command.
The folder tree will have a root folder with the year of the last modification of the file, inside it will create a folder with the month of the last modification of the file.

## Requirements
* Java Runtime Environment (v1.8 min)
* Linux / OSX / Windows

## Installation
* Download the [jar file](https://github.com/DavideRuffolo86/FileOrganizer/releases/tag/1.0)

## Usage

```bash
java -jar fileOrganizer.jar -in=<folder_in> -out=<folder_out>
```

## Example:
```bash
java -jar fileOrganizer.jar -in="c:\myFolder\in" -out="c:\myFolder\out"
```

## Result:

* Before:

```
Downloads
├── project.docx
├── report.pdf
├── image.png
└── archive.7z
```

* After:

```
Downloads
└──2022
   ├── 05
   │    ├── project.docx
   │    └── image.png
   2023
   └── 01
       └── report.pdf
       08
       └── archive.7z
```

# License

[MIT](https://raw.githubusercontent.com/DavideRuffolo86/FileOrganizer/main/LICENSE)