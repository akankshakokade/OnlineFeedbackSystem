function searchSubject(str){
	var obj =new XMLHttpRequest();
	obj.onreadystatechange=function(){
		if(this.readyState==4 && this.status==200){
			document.getElementById("st").innerHTML=obj.responseText;
		}
	}
	obj.open("POST","searchsubject?q="+str+"",true);
	obj.send();
}