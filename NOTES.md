# NOTES

## Compiler

- Programs can only be run if you compile them first and then run using the following syntax:

`fortress compile hello.fss
fortress run hello`

Attempts to run hello.fss directly will throw an error about Fortress being unable to find "hello/fss.class."

- Upon running a program, Fortress may say that it cannot find a built-in compiler method, such as in the following example error:

`matt@matts-exherbo ~/Code/Applications/Fortress/fortress-java-9/ProjectFortress $ ../bin/fortress run hello
Loading class:hello
Loading class:com.sun.fortress.runtimeSystem.BaseTask
Loading class:com.sun.fortress.runtimeSystem.FortressExecutable
Loading class:fortress.CompilerBuiltin$Object
Loading class:fortress.AnyType$Any
Loading class:com.sun.fortress.runtimeSystem.FortressTaskRunnerGroup
Loading class:com.sun.fortress.runtimeSystem.FortressTaskRunnerGroup$FortressForkJoinWorkerThreadFactory
Loading class:com.sun.fortress.runtimeSystem.FortressTaskRunner
Loading class:com.sun.fortress.compiler.runtimeValues.FVoid
Loading class:com.sun.fortress.compiler.runtimeValues.FValue
Loading class:com.sun.fortress.nativeHelpers.systemHelper
Loading class:com.sun.fortress.compiler.runtimeValues.FJavaString
Loading class:fortress.CompilerBuiltin$JavaString
Loading class:fortress.CompilerBuiltin$String
Loading class:fortress.CompilerBuiltin$JavaString$DefaultTraitMethods
Loading class:fortress.CompilerBuiltin
java.lang.NoSuchMethodError: fortress.CompilerBuiltin.println(Lfortress/CompilerBuiltin$Object;)Lcom/sun/fortress/compiler/runtimeValues/FVoid;
	at hello.run(/home/matt/Code/Applications/Fortress/fortress-java-9/ProjectFortress/hello.fss:16)
	at hello.compute(/home/matt/Code/Applications/Fortress/fortress-java-9/ProjectFortress/hello.fss)
	at jsr166y.RecursiveAction.exec(RecursiveAction.java:146)
	at jsr166y.ForkJoinTask.quietlyExec(ForkJoinTask.java:459)
	at jsr166y.ForkJoinWorkerThread.mainLoop(ForkJoinWorkerThread.java:356)
	at jsr166y.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:341)
`

I am unsure of what is causing this at present, as the println function is very clearly defined in CompilerBuiltin.fss. It seems to be a value error, but the same error does not occur when using the interpreter via the "walk" command. Up until that point, all traits successfully loaded. I am unsure of whether the issue is a type mismatch or something else entirely.

Apparently, only some programs compile. Attempts to compile the code samples that I've been writing for Rosetta Code have resulted in errors like that of the following:

`matt@matts-exherbo ~/Code/Fortress/Rosetta Code $ $FORTRESS_HOME/bin/fortress compile loops_while.fss
Exception in thread "main" com.sun.fortress.exceptions.CompilerError:
/home/matt/Code/Fortress/Rosetta Code/loops_while.fss:4:3-16:
    VarDecl (i:ZZ32)=_RewriteFnApp at /home/matt/Code/Fortress/Rosetta Code/loops_while.fss:4.13/home/matt/Code/Fortress/Rosetta Code/loops_while.fss:4:3-16 mutable bindings not yet handled. node = (i:ZZ32)=_RewriteFnApp at /home/matt/Code/Fortress/Rosetta Code/loops_while.fss:4.13/home/matt/Code/Fortress/Rosetta Code/loops_while.fss:4:3-16
	at com.sun.fortress.compiler.codegen.CodeGen.sayWhat(CodeGen.java:1519)
	at com.sun.fortress.compiler.codegen.CodeGen.forVarDeclPrePass(CodeGen.java:5829)
	at com.sun.fortress.compiler.codegen.CodeGen.forComponent(CodeGen.java:1821)
	at com.sun.fortress.nodes.Component.accept(Component.java:56)
	at com.sun.fortress.compiler.phases.CodeGenerationPhase.execute(CodeGenerationPhase.java:190)
	at com.sun.fortress.compiler.phases.Phase.run(Phase.java:52)
	at com.sun.fortress.Shell.analyze(Shell.java:1265)
	at com.sun.fortress.repository.GraphRepository.parseComponent(GraphRepository.java:805)
	at com.sun.fortress.repository.GraphRepository.refreshGraph(GraphRepository.java:511)
	at com.sun.fortress.repository.GraphRepository.getComponent(GraphRepository.java:202)
	at com.sun.fortress.Shell.compilerPhases(Shell.java:968)
	at com.sun.fortress.Shell.compileWithErrorHandling(Shell.java:898)
	at com.sun.fortress.Shell.compilerPhases(Shell.java:874)
	at com.sun.fortress.Shell.subMain(Shell.java:407)
	at com.sun.fortress.Shell.main(Shell.java:362)
	at com.sun.fortress.Shell.main(Shell.java:349)
`

When Java errors aren't thrown, errors such as the following occur:

`matt@matts-exherbo ~/Code/Fortress/Rosetta Code $ $FORTRESS_HOME/bin/fortress compile loops_do_while.fss
/home/matt/Code/Fortress/Rosetta Code/loops_do_while.fss:10:13-14:
    Operator MOD is not defined.
File loops_do_while.fss has 1 error.
`

All of this is valid code in the interpreter. I'm beginning to suspect that the compiler was being phased out in favor of the `walk` command.

- Neither the compiler nor the interptreter work in a commit from May 16th, 2012, despite the commit message stating "Before we do some really speculative hacking."
- Neither the compiler nor the interpter work in the latest commit or in any commits made after June 12, 2012.

## Fortify

**Status:**

Work on a new version of Fortify written in JavaScript has begun. The goal is to create an application that automatically converts Fortress code to mathematical notation without any dependencies, such as the original's dependency on Emacs.

[AsciiMath](http://asciimath.org) seems to be the ideal solution. There are just a few caveats:

- There are a few missing symbols, such as ⊖ (OMINUS), that would have to be implemented.
- There doesn't seem to be a way to bold text.
- Subscripted symbols are required to be placed before superscripted symbols. Example: `QQ_<=^# = z'_o+ -: x^#`
  - The original Fortify tool handles this automatically.

## Atom syntax highlighting

**Status:**

- Basic regexes for core language features written.
- Quite a few types defined FortressBuiltin.fss are missing from the regexes.
- A few use cases aren't accounted for.
- The entire plugin needs to be rewritten to account for scope, variables, and numeric values.

**WIP and alternate code:**

- Multi-line comments regex: `\(\*(\*(?!\))|[^*])*\*\)`
- Enclosed variable parameter regex:
```
{
	'match': '(?<=\[\\)([a-zA-Z0-9\\s]+,*)+(?=\\\])'
	'name': 'variable.parameter.enclosed.fortress'
}
```

## Important information found in code comments

### Generators and Reducers

```
   An object of type Generator[\E\] can "generate values of type E."
   Such generated values are called the //elements// of the generator.

   Generators are used to express iteration in Fortress.  Every
   generated expression in Fortress (such as `for` loops and comprehensions)
   is desugared into calls to methods of `Generator`, chiefly the `generate`
   method.

   Every generator has a notion of a "natural order" (which by default is
   unspecified), which describes the ordering of reduction operations,
   and also describes the order in which elements are produced by the
   sequential version of the same generator (given by the seq(self)
   method).  The default implementation of seq(self) guarantees that these
   orders will match.

   Note in particular that the natural order of a Generator must be
   consistent; that is, if `a SEQV `b then `a` and `b` must yield equivalent
   elements in the same natural order.  However, note that unless a type
   specifically documents otherwise, no particular element ordering is
   guaranteed, nor is it necessary to guarantee that `a=b` implies that
   generators `a` and `b` have the same natural order.

   Note that there are a number of more complex derived generators that
   are specified further down in this file.  These have the same notions
   of natural order and by default are defined in terms of the
   generate() method.

   The `Generator` trait does not assume that equality `=` is defined for
   the generated type.

   The minimal complete definition of a `Generator` is the `generate` method.
```
