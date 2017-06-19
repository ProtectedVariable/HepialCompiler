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
.method public static f(I)I
.limit stack 4
.limit locals 8
iload 0
ldc 2
iadd
ireturn
ldc 0
ireturn
.end method
.method public static main([Ljava/lang/String;)V
.limit stack 8
.limit locals 16
bipush 10
multianewarray [I 1
astore 0
aload 0
ldc 0
ldc 1
iastore
aload 0
ldc 5
ldc 50
iastore
aload 0
ldc 9
ldc 100
iastore
ldc 0
istore 1
for1956725890:
iload 1
ldc 9
isub
ifgt endfor1956725890
aload 0
iload 1
iaload
invokestatic hepial.f(I)I
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/print(I)V
ldc 1
iload 1
iadd
istore 1
goto for1956725890
endfor1956725890:
return
.end method

