# Transfer
Java进制转换库

这是本人写的第一个开源项目，旨在为开发者提供方便的进制转换库，类似于Python里提供二进制、八进制、十六进制的转换函数，本库还提供了从这三种进制转换为十进制的方法。

食用提示：
![step](https://user-images.githubusercontent.com/83149308/226191671-31e6b78e-08dd-4517-9a80-92e1bed25b20.png)
1）在IDEA项目界面 - 文件 - 项目结构 - 模块 - 依赖  
  选择JAR或目录，选中transfer.jar并勾选即可把本库加入到项目依赖中。  
2）导入本库  
  import github.mikey.Transfer  
3）之后的步骤和一般的类使用一致  

Tips：  
1）所有方法返回的都是一个String对象。  
2）传入的参数目前只能是传入正数字符串（不包括0b，0x及用于表示八进制的头部0）。  
3）输出结果样例：  
  （1）0b11.001  
  （2）03.10753  
  （3）0x3.23D7  
  （4）3.140101  
  
方法列表：  
1）toBinary(String)  
  用于将十进制字符串转换为二进制字符串。  
2）toOct(String)  
  用于将十进制字符串转换为八进制字符串。  
3）toHex(String)  
  用于将十进制字符串转换为八进制字符串。  
4）toOrigin(int, String)  
  用于将二进制、八进制和十六进制的字符串转换为十进制字符串。  
  第一个参数代表源字符串进制，第二个参数代表源字符串。  
  
开发者联系方式：  
  Email：bigmikey9527@gmail.com
