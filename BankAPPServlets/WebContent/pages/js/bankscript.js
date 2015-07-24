$(document).ready(function() {
	


	//create the deposit form dynamically
	var deposit = $("<form/>", {id: 'depositForm',action : 'operation',method : 'post'}).append(
				$("<label/>").text('Deposit Amount:'),
				$("<input/>", {type : 'text',id : 'amount',name : 'amount',placeholder : 'Amount'}),
				$("<input/>", {type : 'hidden',id : 'operation',name : 'operation', value:'deposit',placeholder : 'Amount'}),
				$("<br/>"),
				$("<input/>", {type : 'button',value : 'Submit'}));
	  
	  
	  
	//create the withdraw form dynamically 
	var withdraw = $("<form/>", {id: 'withdrawForm',action : 'operation',method : 'post'}).append(
			$("<label/>").text('Withdraw Amount:'),
			$("<input/>", {type : 'text',id : 'amount',name : 'amount',placeholder : 'Amount'}),
			$("<input/>", {type : 'hidden',id : 'operation',name : 'operation', value:'withdraw',placeholder : 'Amount'}),
			$("<br/>"),
			$("<input/>", {type : 'button',id : 'submit',value : 'Submit'}));
	
	
	
	//on click event for deposit button
	  $("#deposit").click(function(){
		  event.preventDefault();
		  $("div#bal").remove();
		  $("#withdrawForm").remove();
		  $("div#form1").append( deposit );
		  
	  });   
	  
	//on click event for deposit button remove previous html code and replace it with withdraw form
	  $("#withdraw").click(function(){
		  event.preventDefault();
		  $("div#bal").remove();
		  $("#depositForm").remove();
		  $("div#form1").append( withdraw );

		  
	  });   
	   
	  //on click event for balance making a AJAX call to the database and to the servlet and getting info back
	  $("#balance").submit(function(){
		  //prevent submiting the form and remove deposit or withdraw form
		  event.preventDefault();
		  $("#depositForm").remove();
		  $("#withdrawForm").remove();
		  
		  //AJAX call
          
          
          $.ajax({
              type: "POST",
              url: "balance",
              dataType: "json",
              data: $("#balance").serialize(),
              
              //if received a response from the server
              success: function( data) {
                  //our country code was correct so we have some information to display
                   if(data.success){
                	   
                      $("div#form1").html("<div id = 'bal'>Your Balance is:" + data.balanceS+"</div>");
                      $("div#form1").slide(500);
                      
                 
                   } 
                   //display error message
                   else {
                	   
                   }
              },
          });        
	  });  
	  
	  
$("#depositForm").submit(function(){
		  
		  $("div#bal").remove();
		  $("#depositForm").remove();
		  $("#withdrawForm").remove();
	
		  //AJAX call
          $.ajax({
              type: "POST",
              url: "operation",
              dataType: "json",
              data: $("#depositForm").serialize(),
              
              //if received a response from the server
              success: function( data) {
                  //our country code was correct so we have some information to display
                   if(data.success){
                	   
                	   $("div#bal").remove();
             		   $("#withdrawForm").remove();
                	   $("div#form1").html("<div id = 'bal'>You Deposit:" + data.amount+"</div>");
                 	   $("div#form1").html("<div id = 'bal'>Your Balance is:" + data.balanceS+"</div>");
                       $("div#form1").slide(500);
                      
                 
                   } 
                   //display error message
                   else {
                	   
                   }
              },
              
    
          }); 
         
		  
	  });   
	  
	  
	  $("#withdrawForm").submit(function(){
		  

		  //AJAX call
          
          
          $.ajax({
              type: "POST",
              url: "operation",
              dataType: "json",
              data: $("#withdrawForm").serialize(),
              
              //if received a response from the server
              success: function( data) {
                  //our country code was correct so we have some information to display
                   if(data.success){
                	   
                	  $("div#form1").html("<div id = 'bal'>You Withdraw:" + data.amount+"</div>");
                	  $("div#form1").html("<div id = 'bal'>Your Balance is:" + data.balanceS+"</div>");
                      $("div#form1").slide(500);
                      
                 
                   } 
                   //display error message
                   else {
                	   $("div#form1").html("<div id = 'bal'>Your Balance is: Insufficient" +data.balanceS+"</div>");
                   }
              },
              
    
          });        
		 
	  });   
	  

	 
	  
});