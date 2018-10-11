# FORTRESS

This is an effort to update Sun's Fortress programming language to work on Java 9 and, later, Java 10. As of 03/26/2018, the interpreter is running and all Java warnings have been cleared. The compiler works, but running compiled programs does not.

## Important notes:

- The version used for this is not quite the final version. Instead, the version used was cloned from a commit made on June 12th, 2012, as later versions threw errors at runtime.
- The original readme file, which includes basic instructions for compiling and running Fortress, as well as setting up the Emacs and Vim script files, is named README.txt and can be found in the base directory of this repository.

## Confirmed working on:

| Platform    | x86 (Java 9)  | x86_64 (Java 9)   | x86 (Java 10) | x86_64 (Java 10)  |
| :---------: | :-----------: | :---------------: | :-----------: | :---------------: |
| Linux       | No            | Yes               | No            | Yes               |
| Mac OS X    | No            | No                | No            | No                |
| Windows 7   | No            | No                | No            | No                |
| Windows 8   | No            | No                | No            | No                |
| Windows 10  | No            | No                | No            | No                |

## To-do list:

### General:

- [x] Get the interpreter running.
- [x] Clear all Java compiler warnings.
- [ ] Clear all Scala compiler warnings.
- [ ] Upgrade Scala to version 2.12.5. *This will require the latest version of the scala.util.parsing library to be manually added to the project.*
- [ ] Ensure that all other dependencies are up to date.
- [ ] Implement features from later versions of Fortress.
- [x] Ensure that Fortify works with the latest version of Emacs. *Fortify works without changes, but the output may need to be updated.*
- [ ] Get the compiler working. *I am currently unsure of whether this is actually necessary.*

### New features:

- [ ] Implement proper IOStream support.
- [ ] Rebuild Fortify without the Emacs dependency.
- [ ] Create interfaces to numerical libraries for Fortress.
  - [ ] BLAS
  - [ ] LAPACK
  - [ ] MPFR
- [ ] Other unimplemented features that were discussed in the specification and/or the readme file.
  - [ ] Coercion

### Packages for code editors:

- [ ] Create a syntax highlighting package for Atom. *Features like the automatic mathematical formula translation found in the Emacs plugin may or may not be introduced later.*
- [ ] Ensure that the Emacs and Vim plugins work with the latest versions of each editor.
  - [ ] Emacs.
  - [x] Vim. *The Vim plugin works without any changes, but it is a fairly basic plugin that doesn't highlight much beyond control structures.*

## Quick setup instructions:

- Make sure that any release of JDK9 or later and Ant 1.9.10 are installed.
- Make sure that the JAVA_HOME and ANT_HOME environment variables are set.
- Clone this repository.
- Set the FORTRESS_HOME environment variable to the folder that you cloned the repository to.
- Enter FORTRESS_HOME in a terminal and type the following:

`./ant clean compile`

- Wait until compilation completes and then test that the interpreter has compiled correctly by typing the following:

`./bin/fortress walk ProjectFortress/demos/sudoku.fss`

If, after a few seconds, the interpreter outputs a solved sudoku puzzle, then the interpreter is up and running. You should now take a look at the documentation and the examples provided.
