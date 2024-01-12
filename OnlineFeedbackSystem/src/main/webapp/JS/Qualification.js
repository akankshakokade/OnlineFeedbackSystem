//add university
function addUniversity(){
	document.getElementById("adduni").innerHTML="";
	let elm = document.createElement("input");
	elm.setAttribute("type","text");
	elm.setAttribute("id","uniname");
	elm.setAttribute("placeholder","Enter New University Name");
	elm.setAttribute("required","required");
	var inp = document.getElementById("adduni");
	inp.style.padding="10px";
	inp.style.backgroundColor="transperant";
	inp.style.display="block";
	inp.style.width="96%";
	var elm1 = inp.appendChild(elm);
	elm1.style.height="5vh";
	elm1.style.width="80%";
	
	let uni = document.createElement("input");
	uni.setAttribute("type","submit");
	uni.setAttribute("onclick","addUni()");
	uni.setAttribute("value","Add New University");
	var inp = document.getElementById("adduni");
	var elm1 = inp.appendChild(uni);
	elm1.style.height="4vh";
	elm1.style.marginLeft="5%";
}
function addUni(){
	var uniname = document.getElementById("uniname").value;
	var obj = new XMLHttpRequest();
	obj.onreadystatechange=function(){
		document.getElementById("adduni").innerHTML="";
		if(this.readyState==4 && this.status==200){
		document.getElementById("adduni").innerHTML=obj.responseText;
		}
	}
	obj.open("POST","adduniversity?uniname="+uniname,true);
	obj.send();
}
//add degree
function addDegree(){
	var data = document.getElementById("adddegree");
	data.innerHTML="";
	let inp = document.createElement("input");
	inp.setAttribute("type","text");
	inp.setAttribute("id","dname");
	inp.setAttribute("placeholder","Enter New Degree Name");
	inp.setAttribute("required","required");
	data.appendChild(inp);
	
	let sub = document.createElement("input");
	sub.setAttribute("type","submit");
	sub.setAttribute("id","dg-btn");
	sub.setAttribute("onclick","adddegree()");
	sub.setAttribute("value","Add Degree");
	data.appendChild(sub);
}
function adddegree(){
	var dname = document.getElementById("dname").value;
	var obj = new XMLHttpRequest();
	obj.onreadystatechange=function(){
		document.getElementById("adddegree").innerHTML="";
		if(this.readyState==4 && this.status==200){
			document.getElementById("adddegree").innerHTML=obj.responseText;
		}
	}
	obj.open("POST","adddegree?dname="+dname);
	obj.send();
}
//add skill
function addSkill(){
	var data = document.getElementById("addskills");
	data.innerHTML="";
	let inp = document.createElement("input");
	inp.setAttribute("type","text");
	inp.setAttribute("id","skname");
	inp.setAttribute("Placeholder","Enter Skill Name");
	inp.setAttribute("required","required");
	data.appendChild(inp);
	
	let sub = document.createElement("input");
	sub.setAttribute("type","submit");
	sub.setAttribute("id","sk-btn");
	sub.setAttribute("value","Add New Skill");
	sub.setAttribute("onclick","addskill()");
	data.appendChild(sub);
}
function addskill(){
	var data = document.getElementById("skname").value;
	let obj = new XMLHttpRequest();
	obj.onreadystatechange=function(){
		if(this.readyState==4 && this.status==200){
			document.getElementById("addskills").innerHTML=obj.responseText;
		}
	}
	obj.open("POST","addskill?skname="+data,true);
	obj.send();
}
//for feedback question add
//for FeedBackQuestions.java
function addQuestion(){
	let data = document.getElementById("qtn").value;
	let obj = new XMLHttpRequest();
	obj.onreadystatechange = function(){
		if(this.readyState==4 && this.status==200){
			document.getElementById("question").innerHTML=obj.responseText;
		}
	}
	obj.open("POST","feedbackquestionload?qtn="+data,true);
	obj.send();
}
function deleteQuestion(id){
	let b = confirm("Do You Want To Delete?")
	if(b){
		let obj = new XMLHttpRequest();
	obj.onreadystatechange = function(){
		if(this.readyState==4 && this.status==200){
			document.getElementById("question").innerHTML=obj.responseText;
		}
	}
	obj.open("POST","deletefeedbackquestion?qtn="+id,true);
	obj.send();
	}
}