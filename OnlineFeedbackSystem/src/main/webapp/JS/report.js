/*SubjectWiseTrianer*/
	function subjectWiseTrainer(id){
		let obj = new XMLHttpRequest();
		obj.onreadystatechange = function(){
			if(this.readyState==4 && this.status==200){
				document.getElementById("subjectwisetrainer").innerHTML=obj.responseText;
			}
		}
		obj.open("POST","getsubjectwisetrainer?id="+id,true);
		obj.send();
	}
/*SubjectWiseStudent*/
	function subjectWiseStudent(id){
		let obj = new XMLHttpRequest();
		obj.onreadystatechange = function(){
			if(this.readyState==4 && this.status==200){
				document.getElementById("subjectwisestudent").innerHTML=obj.responseText;
			}
		}
		obj.open("POST","GetSubjectWiseStudent?id="+id,true);
		obj.send();
	}