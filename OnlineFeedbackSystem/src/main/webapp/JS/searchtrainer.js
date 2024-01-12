//		search trainer for alltrainer Servlet
function searchTrainer(str){
	var searchBy = document.getElementById("searchBy").value;
	let obj = new XMLHttpRequest();
	obj.onreadystatechange=function(){
		if(this.readyState==4 && this.status==200){
			document.getElementById("searchTrainers").innerHTML=obj.responseText;
		}
	}
	obj.open("POST","searchtrainer?data="+str+"&searchby="+searchBy+"&page="+1,true);
	obj.send();
}

//		search trainer for UpdateTrainer servlet
function searchTrainer2(str){
	var searchBy = document.getElementById("searchBy").value;
	let obj = new XMLHttpRequest();
	obj.onreadystatechange=function(){
		if(this.readyState==4 && this.status==200){
			document.getElementById("searchTrainers").innerHTML=obj.responseText;
		}
	}
	obj.open("POST","searchtrainer?data="+str+"&searchby="+searchBy+"&page="+2,true);
	obj.send();
}

//		enable disable trainer status
//		for updateTrainer servlet
function trainerStatus(id,status){
	let obj = new XMLHttpRequest();
	obj.onreadystatechange=function(){
		if(this.readyState==4 && this.status==200){
			document.getElementById("searchTrainers").innerHTML=obj.responseText;
		}
	}
	obj.open("POST","trainerstatus?tid="+id+"&status="+status,true);
	obj.send();
}

//		for delete trainer
//		for DeleteTrainer servlet
function trainerDelete(id){
	var result = confirm("Do You Want To Delete!");
	if (result == true) {
        let obj = new XMLHttpRequest();
		obj.onreadystatechange=function(){
			if(this.readyState==4 && this.status==200){
				document.getElementById("searchTrainers").innerHTML=obj.responseText;	
			}
		}
		page="trainerdelete";
		obj.open("POST","deletetrainer?tid="+id+"&page="+1,true);
		obj.send();
    }
}

//for updateTrainerSkill servlet
function deleteSkill(tid,id){
	var result = confirm("Do You Want To Delete!!!");
	if(result==true){
		let obj = new XMLHttpRequest();
		obj.onreadystatechange=function(){
			if(this.readyState==4 && this.status==200){
				document.getElementById("skillcontainer").innerHTML=obj.responseText;
			}
		}
		obj.open("POST","deletetrainerskill?tid="+tid+"&skid="+id+"&page="+2,true);
		obj.send();
	}
}
function addnewSkill(tid){
/*setTimeout(addSkill(),1000);*/
		let obj = new XMLHttpRequest();
		obj.onreadystatechange=function(){
			if(this.readyState==4 && this.status==200){
				document.getElementById("skillcontainer").innerHTML=obj.responseText;
			}
		}
		obj.open("POST","searchtrainer?tid="+tid+"&page="+3,true);
		obj.send();
}
//for TranerQualificationSkill servlet
//for delete trainer Qualification
function deleteQualifi(tid,did,clgid){
	let obj = new XMLHttpRequest();
	obj.onredystatechange = function(){
		if(this.readyState==4 && this.status==200){
			document.getElementById("qli").innerHTML=obj.responseText;
		}
	}
	obj.open("POST","deletetrainerqualification?tid="+tid+"&did="+did+"&clgid="+clgid,true );
	obj.send();
}
/*for allocate subject to trainer*/
	function getSub(){
		let tid = document.getElementById("tid").value;
		let subid = document.getElementById("subid").value;
		let obj = new XMLHttpRequest();
		obj.onreadystatechange = function(){
			if(this.readyState==4 && this.status==200){
				document.getElementById("output").innerHTML=obj.responseText;
				getSubject(tid);
			}
		}
		obj.open("POST","allocatesubjecttotrainerr?tid="+tid+"&subid="+subid,true);
		obj.send();
	}
/*getAllocatedSubjectToTrainer*/
	function getSubject(id){
		let obj = new XMLHttpRequest();
		obj.onreadystatechange = function(){
			if(this.readyState==4 && this.status==200){
				document.getElementById("allocatedsubject").innerHTML=obj.responseText;
			}
		}
		obj.open("POST","getallocatedsubjectfortrainer?id="+id,true);
		obj.send();
	}
/*for remove allocatedSubject*/
	function removeAllocatedSubject(tid,subid){
		let b = confirm("Did You Want To Remove Subject ?");
		if(b==true){let obj = new XMLHttpRequest();
		obj.onreadystatechange = function(){
			if(this.readyState==4 && this.status==200){
				document.getElementById("allocatedsubject").innerHTML=obj.responseText;
			}
		}
		obj.open("post","removetrainerallocatedsubject?tid="+tid+"&subid="+subid,true);
		obj.send();
		}
	}
	
	
	
	
	
	
	
	