	//validation
		function nameValidation(str){
            var newStr = str.match(/^[a-z' 'A-Z]+$/);
            //here ^ represent, String must be start with upper case or lower case character
            //here + represent, String is combination of multiple character
            //here $ represent, string must be end with uppercase and lowercase character
            if(newStr==null){
                document.getElementById("validname").innerHTML="Invalid Name";
                document.getElementById("validname").style.color='red';
            }else{
                document.getElementById("validname").innerHTML="";
            }
        }
        function contactValidation(str){
            var exp=/^\d{10}$/;
            //^ represent stating of must be from digits
            //\d represent find digits from string
            //{10} exact 10 digits requeired
            //$ string end with digits  
            var result = str.match(exp);
            if(result==null){
                document.getElementById("validcontact").innerHTML="Invalid Contact";
                document.getElementById("validcontact").style.color='red';
            }else{
                document.getElementById("validcontact").innerHTML="";
            }
        }
        function passwordValidation(str){
            var exp =/^(?=.*[A-Z])(?=.*[a-z])(?=.*\d).{8,}$/;
            var result = str.match(exp);
            if(result==null){
                document.getElementById("validpassword").innerHTML="Invalid Password";
                document.getElementById("validpassword").style.color='red';
            }else{
                document.getElementById("validpassword").innerHTML="";
            }
        }
        function emailValidation(str){
            var exp = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            var result = str.match(exp);
            if(result==null){
                document.getElementById("validemail").innerHTML="Invalid E-mail";
                document.getElementById("validemail").style.color='red';
            }else{
                document.getElementById("validemail").innerHTML="";
            }
        }
        function validdate() {
			alert("ok");
			let dateString = document.getElementById("dob").value;
  			const dateRegex = /^(19|20)\d\d-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/;
  
  			if (!dateRegex.match(dateString)) {
   				document.getElementById("validdate").innerHTML="Invalid Date";
                document.getElementById("validdate").style.color='red';
  			}
  			else{
				  document.getElementById("validdate").innerHTML="valid Date";  
			}
  
 			const dob = new Date(dateString);
  			const currentDate = new Date();

  			// Compare the parsed date with the current date
  			if (dob > currentDate) {
    			document.getElementById("validdate").innerHTML="Please Enter Proper Date!";
                document.getElementById("validdate").style.color='red';
  			}
  			document.getElementById("validdate").innerHTML="";
		}