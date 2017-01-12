<!DOCTYPE html>
<html >
    <#include "/header.ftl" >
    <body>
       
       <center>
       <img src = "/images/logo.jpg">
       <h1 id = "title">${title}</h1>
       </center>
       
     
       
       <form method="POST" enctype="multipart/form-data" action="/file/upload">
          文件：<input type="file" name="roncooFile" />
       <input type="submit" value="上传" />
     </form>
       
       <script>
           $(function(){
               $('#title').click(function(){
                    alert('点击了title');
               });
           })
           </script>
       
       <p>
           welcome ${name}  to freemarker!
       </p>      
      
      
       <p>性别：
           <#if id==0>
              女
           <#elseif id==1>
              男
           <#else>
              保密   
           </#if>
        </p>
      
      <#--遍历friends-->
      
       <h4>我的好友：</h4>
       <#list friends as item>
           姓名：${item.name} , 生日：${item.date?string("yyyy-MM-dd HH:mm:ss zzzz")}  
           <br>
       </#list>
      
      
    </body>
       <#include "/footer.ftl" >
</html>