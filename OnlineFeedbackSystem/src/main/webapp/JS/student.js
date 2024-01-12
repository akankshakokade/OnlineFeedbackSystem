/* viewall student servlet for seach students */
	function searchStudents(str){
		let obj = new XMLHttpRequest();
		obj.onreadystatechange = function(){
			if(this.readyState==4 && this.status==200){
				document.getElementById("viewstudent").innerHTML=obj.responseText;
			}
		}
		obj.open("POST","searchviewstudent?str="+str,true);
		obj.send();
	}
/*deleteStudent servlet*/
	function deleteStudent(id){
		let flag = confirm("Do You Want to Delete");
		if(flag==true){
			let obj = new XMLHttpRequest();
			obj.onreadystatechange = function(){
			if(this.readyState==4 && this.status==200){
				document.getElementById("viewstudent").innerHTML=obj.responseText;
			}
		}
		obj.open("POST","deletestudent?id="+id,true);
		obj.send();
		}
	}
/*studentStatus servlet*/
	function studentStatus(id, status){
		let obj = new XMLHttpRequest();
		obj.onreadystatechange = function(){
			if(this.readyState==4 && this.status==200){
				document.getElementById("viewstudent").innerHTML=obj.responseText;
			}
		}
		obj.open("POST","studentstatus?id="+id+"&status="+status,true);
		obj.send();
	}
/*updateStudent servlet*/
	function goToUpdateStudent(id){
		window.location.href = 'updatestudentinfo?id='+id;
	}
/*for allocate subject to student*/
	function getSub(){
		let stid = document.getElementById("stid").value;
		let subid = document.getElementById("subid").value;
		let obj = new XMLHttpRequest();
		obj.onreadystatechange = function(){
			if(this.readyState==4 && this.status==200){
				document.getElementById("output").innerHTML=obj.responseText;
				getSubject(stid);
			}
		}
		obj.open("POST","allocatesubjecttostudentajx?stid="+stid+"&subid="+subid,true);
		obj.send();
	}
/*getAllocatedSubjectToStudent*/
	function getSubject(id){
		let obj = new XMLHttpRequest();
		obj.onreadystatechange = function(){
			if(this.readyState==4 && this.status==200){
				document.getElementById("allocatedsubject").innerHTML=obj.responseText;
			}
		}
		obj.open("POST","getallocatedsubjecttostudent?id="+id,true);
		obj.send();
	}
/*for remove allocatedSubject*/
	function removeAllocatedSubject(stid,subid){
		let b = confirm("Did You Want To Remove Subject ?");
		if(b==true){let obj = new XMLHttpRequest();
		obj.onreadystatechange = function(){
			if(this.readyState==4 && this.status==200){
				document.getElementById("allocatedsubject").innerHTML=obj.responseText;
			}
		}
		obj.open("post","removeallocatedsubjecttostudent?stid="+stid+"&subid="+subid,true);
		obj.send();
		}
	}