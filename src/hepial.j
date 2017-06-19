.class public hepial
.super java/lang/Object
.method public <init>()V
aload_0 
invokespecial java/lang/Object/<init>()V 
return
.end method
.method public static read()I
.limit locals 10
.limit stack 10
new java/util/Scanner
dup
getstatic java/lang/System/in Ljava/io/InputStream;
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V
invokevirtual java/util/Scanner/nextInt()I
ireturn
.end method
.method public static main([Ljava/lang/String;)V
.limit stack 5
.limit locals 4
ldc 12
istore 0
iload 0
ldc 12
isub
ifeq if356573597_then
goto if356573597_else
if356573597_then:
ldc "YOUHOU"
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
goto endif356573597
if356573597_else:
ldc 21
istore 0
endif356573597:
iload 0
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/print(I)V
return
.end method

