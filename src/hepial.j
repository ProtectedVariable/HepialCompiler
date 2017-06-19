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
.limit stack 6
.limit locals 8
ldc 12
istore 0
iload 0
ldc 1
iadd
istore 0
ldc 1
ldc 1
isub
ifeq if1956725890_then
goto if1956725890_else
if1956725890_then:
iload 0
ldc 2
iadd
istore 0
goto endif1956725890
if1956725890_else:
iload 0
ldc 2
isub
istore 0
endif1956725890:
return
.end method

