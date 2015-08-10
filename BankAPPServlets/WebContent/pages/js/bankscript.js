$(document).ready(function() {
	


	//create the deposit form dynamically
	var deposit = $("<form />", { id: 'depositForm',action : 'operation',method : 'post'}).append(
				$("<label/>").text('Deposit Amount:'),
				$("<input/>", {type : 'text',id : 'amount',name : 'amount',placeholder : 'Amount'}),
				$("<input/>", {type : 'hidden',id : 'operation',name : 'operation', value:'deposit',placeholder : 'Amount'}),
				$("<br/>"),
				$("<input/>", {type : 'submit', id: 'depositBtn',value : 'Submit'}));
	  
	  
	  
	//create the withdraw form dynamically 
	var withdraw = $("<form/>", {id: 'withdrawForm',action : 'operation',method : 'post'}).append(
			$("<label/>").text('Withdraw Amount:'),
			$("<input/>", {type : 'text',id : 'amount',name : 'amount',placeholder : 'Amount'}),
			$("<input/>", {type : 'hidden',id : 'operation',name : 'operation', value:'withdraw',placeholder : 'Amount'}),
			$("<br/>"),
			$("<input/>", {class: 'buttonS',type : 'submit',id : 'withdrawBtn',value : 'Submit'}));
	
	
	//on click event for deposit button
	  $("#btn-deposit").click(function(e){
		  e.preventDefault();
		  $("div#welcome").remove();
		  $("div#bal").remove();
		  $("#withdrawForm").remove();
		  $("div#form1").append( deposit ).slide(500);;
		  
	  });   
	

	  
	//on click event for deposit button remove previous html code and replace it with withdraw form
	  $("#btn-withdraw").click(function(e){
		  e.preventDefault();
		  $("div#bal").remove();
		  $("#depositForm").remove();
		  $("div#welcome").remove();
		  $("div#form1").append( withdraw).slide(500);

		  
	  });   

	  //on click event for balance making a AJAX call to the database and to the servlet and getting info back
	  $("#btn-balance").click(function(e){
		  //prevent submiting the form and remove deposit or withdraw form
		  e.preventDefault();
		  $("#depositForm").remove();
		  $("#withdrawForm").remove();
		  $("div#welcome").remove();
		  
		  //AJAX call
          
          
          $.ajax({
              type: "POST",
              url: "balance",
              dataType: "json",
              data: $("#balance").serialize(),
              
              //if received a response from the server
              success: function( data) {
             
                   if(data.success){
                	   
                      $("div#form1").html("<div id = 'bal'>Your Balance is: " + data.balanceS.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1,')+"</div>");
                      $("div#form1").slide(500);
                      
                 
                   } 
                   //display error message
                   else {
                	   
                   }
              },
          });        
	  });  
	  
	
	      
		
           
		$(function() {
		    $(document).on("submit", "#depositForm", function(e){
		    	e.preventDefault();
		
		    	
				  //AJAX call
		        $.ajax({
		            type: "POST",
		            url: "operation",
		            dataType: "json",
		            data: $("#depositForm").serialize(),
		            
		            //if received a response from the server
		            success: function( data) {
		                
		                 if(data.success){
		              	   
		              	   $("div#bal").remove();
		              	   $("div#welcome").remove();
		           		   $("#withdrawForm").remove();
		           		   $("#depositForm").remove();
		              	   $("div#form1").html("<div id = 'bal'>You Deposit: " + data.amount.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1,')+"</div>");
		              	   $("div#bal").append("<br>");
		              	   $("div#bal").append("<p>Your Balance is: " + data.balanceS.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1,')+"</p>");
		                   $("div#bal").slide(5000);
		                    
		               
		                 } 
		                 //display error message
		                 else {
		              	   
		                 }
		            },
		            
		  
		        }); 
		    });
		});

		$(function() {
		    $(document).on("submit", "#withdrawForm", function(e){
		    	 e.preventDefault();
				  //AJAX call
		         
		         
		         $.ajax({
		             type: "POST",
		             url: "operation",
		             dataType: "json",
		             data: $("#withdrawForm").serialize(),
		             
		             //if received a response from the server
		             success: function( data) {
		                 
		                  if(data.success){
		               	   
			                	  $("div#bal").remove();
			             		  $("#withdrawForm").remove();
			             		  $("#depositForm").remove();
			             		  $("div#welcome").remove();
			                	  $("div#form1").html("<div id = 'bal'>You Withdraw: $" + data.amount.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1,')+"</div>");
			                	  $("div#bal").append("<br>");
				              	   $("div#bal").append("<p>Your Balance is: $" + data.balanceS.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1,'));
				                   $("div#bal").slide(5000);
		                     	
		                
		                  } 
		                  //display error message
		                  else {
		               	   $("div#form1").html("<div id = 'bal'>Your Balance is: Insufficient" +data.balanceS.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1,')+"</div>");
		                  }
		             },
		             
		   
		         });        
		    });
		});
	  
	   
});//end of document

 
   