<jsp:useBean id="userinfo" class="bean.UserBean"></jsp:useBean>
<jsp:setProperty property="*" name="userinfo" />
You have enterted below details:
<br>
<h2>
	Customer Name: ${userinfo.name}<br> 
	Customer Password: ${userinfo.password}<br>
	Age: ${userinfo.age}<br>
</h2>
