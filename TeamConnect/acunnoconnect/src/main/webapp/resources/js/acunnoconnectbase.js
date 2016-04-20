// for future reference ${pageContext.request.contextPath}
var acunnocontext = 'acunnoconnect';


function userLoginAction(){
	
	var username = $("#username").val();
	var password = $("#userpassword").val();

	$.ajax( {
		type : 'POST',
		//url : '/'+${pageContext.request.contextPath}+'userLogin' + '?emailId='+ username+'&password='+password,
		url : '/'+acunnocontext+'/userLogin' + '?emailId='+ username+'&password='+password,
	    success : function(response) {
	    	alert('1234');
	    },
	    failure:function(response){
	    	
	    }
	});
}

function populateGroupMessagesForUser(){
	var emailId = $("#loggedInUserIdVar").val();
	
	var repeatblock  = '<div class="well well-sm">'+
	'<a href="#question_REPLACEWITHSECTION" onclick="populateMessageDetails(\'REPLACEWITHID\')" data-toggle="collapse">REPLACEWITHQUESTIONHEADER</a>'+
	'<div class="collapse" id="question_REPLACEWITHSECTION">'+
		'<div class="b-bottom" id="question_REPLACEWITHSECTION_body">'+
			'<p class="sub">REPLACEWITHQUESTIONBODY.</p>'+
			'<p>On REPLACEWITHQUESTIONDATE '+
				'<a class="span_link" href="#">'+
					'<span class="glyphicon glyphicon-comment"></span>'+
					'0'+
				'</a>'+
				'<a class="span_link" href="#">'+
					'<span class="glyphicon glyphicon-eye-open">'+
					'</span>'+
					'56'+ 
				'</a>'+
			'</p>'+
		'</div>'+
		'<div class="response"><h4>Responses</h4>'+
			'<div class="media response-info">'+
				'<div class="media-left response-text-left">'+
					'<a href="#"><img class="media-object" src="images/sin1.jpg" alt="" /></a><h5>'+
					'<a href="#">Username</a></h5> '+
				'</div>'+
				'<div class="media-body response-text-right">'+
					'<p>REPLACEWITHRESPONSE1</p>'+
					'<ul>'+
						'<li>REPLACEWITHRESPONSEDATE1</li>'+
					'</ul>'+
				'</div>'+
			'</div>'+
		    '<div class="media response-info">'+
			  '<div class="media-left response-text-left">'+
				  '<a href="#"> <img class="media-object" src="images/sin2.jpg" alt="" /></a>'+
				  '<h5><a href="#">Username</a></h5>'+
			  '</div>'+
			  '<div class="media-body response-text-right">'+
				'<p>REPLACEWITHRESPONSE2</p>'+
				'<ul>'+
					'<li>REPLACEWITHRESPONSEDATE2</li>'+
				'</ul>'+
			  '</div>'+
			  '<div class="clearfix">'+
			  '</div>'+
			'</div>'+
		'</div>'+
		'<div class="clearfix">'+
		'</div>'+
	'</div>'+
'</div>';
	
	
	$.ajax( {
		type : 'POST',
		url : '/'+acunnocontext+'/getUserGroupMessages' + '?emailId='+ emailId+'&groupId='+emailId+'&generatedtokenId='+emailId+'&listingType=all',
	    success : function(response) {
	    	var allresponses = eval('(' + response + ')');
			if (allresponses){
				//response object has response object
				var questionscount = allresponses.questionscount;
				var responseObject = allresponses.questions;
				
				var groupblock = '';
				if(questionscount>0){
					for ( var i = 0; i < responseObject.length; i++) {
						var newrepeatblock = repeatblock;
						newrepeatblock = newrepeatblock.split('REPLACEWITHSECTION').join('listing_'+responseObject[i].questionId);
						newrepeatblock = newrepeatblock.split('REPLACEWITHID').join(responseObject[i].questionId);
						newrepeatblock = newrepeatblock.split('REPLACEWITHQUESTIONHEADER').join(''+responseObject[i].questionHeader);
						newrepeatblock = newrepeatblock.split('REPLACEWITHQUESTIONBODY').join(''+responseObject[i].questionHeader);
						groupblock = groupblock+newrepeatblock;
					}
				}
				$("#applicationscontainer").html('');
				$("#applicationscontainer").html(groupblock);
			}
	    },
	    failure:function(response){
	    	
	    }
	});
}

function populateMessageDetails(messageId){
	
	var emailId = $("#loggedInUserIdVar").val();
	
	var replyblockOnly = '<div class="b-bottom" id="question_REPLACEWITHSECTION_body">'+
	'<p class="sub">REPLACEWITHQUESTIONBODY.</p>'+
	'<p>On REPLACEWITHQUESTIONDATE '+
		'<a class="span_link" href="#">'+
			'<span class="glyphicon glyphicon-comment"></span>'+
			'0'+
		'</a>'+
		'<a class="span_link" href="#">'+
			'<span class="glyphicon glyphicon-eye-open">'+
			'</span>'+
			'56'+ 
		'</a>'+
	'</p>'+
'</div>'+
'<div class="coment-form">'+
	'<h4>Leave your comment'+
	'</h4>'+
	'<form>'+
		'<textarea id="response_REPLACEWITHSECTION_text" onfocus="this.value = \'\';"onblur="if (this.value == \'\') {this.value = \'Your Comment...\';}" required="">Your Comment...</textarea>'+
		'<input type="button" value="REPLY" class="btn submit_button_reply" onclick="submitresponse(\'REPLACEWITHSECTION\',\'REPLACEWITHASKEDBY\')">'+
	'</form>'+
'</div>'+
'<div class="clearfix">'+
'</div>';
	
	var responsesblock = '<div class="b-bottom" id="question_REPLACEWITHSECTION_body">'+
	'<p class="sub">REPLACEWITHQUESTIONBODY.</p>'+
	'<p>On REPLACEWITHQUESTIONDATE '+
		'<a class="span_link" href="#">'+
			'<span class="glyphicon glyphicon-comment"></span>'+
			'REPLACEWITHCOUNTOFRESPONSES'+
		'</a>'+
		'<a class="span_link" href="#">'+
			'<span class="glyphicon glyphicon-eye-open">'+
			'</span>'+
			'56'+ 
		'</a>'+
	'</p>'+
'</div>'+
'<div class="coment-form">'+
	'<h4>Leave your comment'+
	'</h4>'+
	'<form>'+
		'<textarea id="response_REPLACEWITHSECTION_text" onfocus="this.value = \'\';"onblur="if (this.value == \'\') {this.value = \'Your Comment...\';}" required="">Your Comment...</textarea>'+
		'<input type="button" value="REPLY" class="btn submit_button_reply" onclick="submitresponse(\'REPLACEWITHSECTION\',\'REPLACEWITHASKEDBY\')">'+
		//'<div style="position:relative;"><a><input type="file" style="position:absolute;z-index:2;top:0;left:0;filter: alpha(opacity=0);-ms-filter:"progid:DXImageTransform.Microsoft.Alpha(Opacity=0)";opacity:0;background-color:transparent;color:transparent;\' name="file_source" size="40"  onchange="$(\'#upload-file-info\').html($(this).val());">'+
        //'</a></div>'+
	'</form>'+
'</div>'+
'REPLACERESPONSESHERE'+
'<div class="clearfix">'+
'</div>';
	
	var singleresponseblock = '<div class="media response-info">'+
	'<div class="media-left response-text-left">'+
	'<a href="#"><img class="media-object" src="images/sin1.jpg" alt="" /></a><h5>'+
	'<a href="#">REPLACEWITHRESPONDEDUSER</a></h5> '+
		'</div>'+
		'<div class="media-body response-text-right">'+
			'<p>REPLACEWITHRESPONSE</p>'+
			'<ul>'+
				'<li>REPLACEWITHDATERESPONSE</li>'+
			'</ul>'+
		'</div>'+
		'</div>';
	
	var blockname = 'question_listing_'+messageId;
	var id = messageId.split('listing_');
	
	$.ajax( {
		type : 'POST',
		url : '/'+acunnocontext+'/getQuestionDetails' + '?questionId=' + messageId+'&emailId='+ emailId+'&groupId='+emailId+'&generatedtokenId='+emailId+'&listingType=all',
	    success : function(response) {
	    	var responseObject = eval('(' + response + ')');
			//response object has response object 
				var groupblock = '';
				var responseCount = responseObject.responsecount;
				var questionDetails = responseObject.questiondetail;
				var userresponses = responseObject.responses;
				
				var newrepeatblock = responsesblock;
				newrepeatblock = newrepeatblock.split('REPLACEWITHQUESTIONBODY').join(''+questionDetails.question);
				newrepeatblock = newrepeatblock.split('REPLACEWITHSECTION').join('listing_'+questionDetails.questionId);
				newrepeatblock = newrepeatblock.split('REPLACEWITHQUESTIONDATE').join(questionDetails.askeddate);
				newrepeatblock = newrepeatblock.split('REPLACEWITHCOUNTOFRESPONSES').join(responseCount);
				newrepeatblock = newrepeatblock.split('REPLACEWITHASKEDBY').join(questionDetails.emailId);
				
				
				if(responseCount>0){
					var responseArray = userresponses;
					var allresponsesBlock = '';
					for ( var i = 0; i < responseArray.length; i++) {
						var newrepeatresponseblock = singleresponseblock;
						newrepeatresponseblock = newrepeatresponseblock.split('REPLACEWITHRESPONSE').join(''+responseArray[i].responseContent);
						newrepeatresponseblock = newrepeatresponseblock.split('REPLACEWITHDATERESPONSE').join(''+responseArray[i].createDate);
						newrepeatresponseblock = newrepeatresponseblock.split('REPLACEWITHRESPONDEDUSER').join(''+responseArray[i].createdBy);
						allresponsesBlock = allresponsesBlock+newrepeatresponseblock;
					}
					newrepeatblock = newrepeatblock.split('REPLACERESPONSESHERE').join(allresponsesBlock);
				}else{
					newrepeatblock = newrepeatblock.split('REPLACERESPONSESHERE').join('');
			
				}
				groupblock = groupblock+newrepeatblock;
				
				$("#"+blockname).html('');
				$("#"+blockname).html(groupblock);
		
	    },
	    failure:function(response){
	    	
	    }
	});

}


function submitresponse(messageId, questionPostedBy){
	var textmessageId = 'response_'+messageId+'_text';
	var emailId = $("#loggedInUserIdVar").val();
	var questionId = messageId.split('listing_').join('');
	var responsecontent = $('#'+textmessageId).val();
	
	$.ajax( {
		type : 'POST',
		url : '/'+acunnocontext+'/postResponse' + '?questionId=' + questionId+'&emailId='+ emailId+'&groupId='+emailId+'&generatedtokenId='+emailId+'&responseContent='+responsecontent+'&questionPostedBy='+questionPostedBy,
	    success : function(response) {
	    	var allresponses = eval('(' + response + ')');
			if (allresponses) {
				if(allresponses.mesaage='success'){
					populateMessageDetails(questionId);	
				}else{
					alert('failure');
					populateMessageDetails(questionId);
				}
			}
	    	
	    },
	    failure:function(response){
	    	
	    }
	});


}


function postnewmessage(){
	var questionblockOnly = '<div class="well well-sm"><div class="collapse in" id="question_listing_new"><div class="coment-form"><h4>Post New Group Message</h4><form>'+
							'<div class="form-group"><label for="usr">Subject:</label><input type="text" class="form-control" id="question_new_subject"></div>'+
							'<div class="form-group"><label for="usr">Groups:</label><input type="text" class="form-control" id="question_new_group"></div>'+
							'<div class="form-group"><label for="usr">Tags:</label><input type="text" class="form-control" id="question_new_tags"></div>'+
							'<textarea id="question_new_content" onfocus="this.value = \'\';" '+ 
								'onblur="if (this.value == \'\') {this.value = \'Your Comment...\';}"'+
										' required=\'\'>Post your question...</textarea><input type="button" value="POST" class="btn submit_button_reply" onclick="postnewquestiontogroup(\'\')"><div style="position:relative;"><a><input type="file" '+
										'style="position:absolute;z-index:2;top:0;left:0;filter: alpha(opacity=0);-ms-filter:" progid:dximagetransform.microsoft.alpha(opacity="0)&quot;;opacity:0;background-color:transparent;color:transparent;\'"'+
										'name="file_source" size="40" onchange="$(\'#upload-file-info\').html($(this).val());"></a></div></form></div><div class="clearfix"></div></div></div>';
	
	
	$("#applicationscontainer").html('');
	$("#applicationscontainer").html(questionblockOnly);
	
}


function postnewquestiontogroup(){
	var questionsubject = $("#question_new_subject").val();
	var questiongroup = $("#question_new_group").val();
	var questiontags = $("#question_new_tags").val();
	var questioncontent = $("#question_new_content").val();
	var emailId = $("#loggedInUserIdVar").val();
	
	$.ajax( {
		type : 'POST',
		url : '/'+acunnocontext+'/postQuestionToGroup',
		data: { 
		       'question': questioncontent, 
		       'emailId': emailId,
		       'groupId': questiongroup,
		       'questionHeader':questionsubject,
		       'questiontags':questiontags
		},
	    success : function(response) {
	    	populateGroupMessagesForUser();
	    },
	    failure:function(response){
	    	
	    }
	});


}

function registerNewUser(){
	
	var registerfirstname = $("#registerfirstname").val();
	var registerlastname = $("#registerlastname").val();
	var registeremailid = $("#registeremailid").val();
	var registerpassword = $("#registerpassword").val();
	var registerconfirmpassword = $("#registerpasswordconfirm").val();
	
	var error = false;
	if(registerconfirmpassword==null){
		error = true;
	}
	if(registerpassword==null){
		error = true;
	}
	if(registeremailid==null){
		error = true;
	}
	if(registerfirstname==null){
		error = true;
	}
	if(registerlastname==null){
		error = true;
	}
	if(!error){
		var checkattherate = registeremailid.split('@');
		if(checkattherate.length < 2){
			$("#errormessage").html("Please enter a valid emailId");
			return false;
		}
		$("#errormessage").html("");
		$("#userRegistrationBtn").prop('disabled', true);;
		
		
		$.ajax( {
			type : 'POST',
			url : '/'+acunnocontext+'/registerUser' + '?emailId=' + registeremailid+'&firstName='+ registerfirstname+'&lastName='+registerlastname+'&password='+registerpassword,
		    success : function(response) {
		    	var allresponses = eval('(' + response + ')');
				if (allresponses) {
					var responseMessage = allresponses.message;
					$("#errormessage").html(responseMessage);
					$("#userRegistrationBtn").prop('disabled', false);;
				}
		    },
		    failure:function(response){
		    }
		});
	}else{
		$("#errormessage").html("All Fields are Mandatory, please ensure they are complete");
		$("#errormessage").show();
		return false;
	}
	
}



function managegroups(){
	$("#applicationscontainer").html('');	
	$("#postnewgroupmessage_btn").hide();
	$("#groupmessageoptions_dd").hide();
	
	var tabbedPaneContent = '<ul class="list-inline"><li class="tabbedpaneltoptabs" id="mygroupoption"><a href="javascript:void[0]" onclick="showmygroups()">My Groups</a></li>'+
		     '<li class="tabbedpaneltoptabs" id="allgroupoption"><a href="javascript:void[0]" onclick="showallgroups()">All Groups</a></li>'+
    		 '<li class="tabbedpaneltoptabs" id="grouprequestoption"><a href="javascript:void[0]" onclick="showgrouprequests()">Group Requests</a></li>'+
    		 '<li class="tabbedpaneltoptabs" id="groupdetails"><a href="javascript:void[0]">Group Details</a></li>'+
    		 '<li class="tabbedpaneladdoption" id="addnewgrouporuser"><a href="javascript:void[0]" onclick="displayaddnewgroupform()" id="addnewgroup"><span class="glyphicon glyphicon-plus-sign" title="addnew group" ></span></a><a href="javascript:void[0]" onclick="displayaddnewuserform()" id="addnewmember"><span class="glyphicon glyphicon-user" title="addnew member"></span></a></li></ul>'+
    		 '<span id="usergroupactionform"></span>'+
		     '<span id="usergroupscontent"></span>';
	
	$("#applicationscontainer").html(tabbedPaneContent);
	showallgroups();
}


var tablegroupscontentDummy = '<table class="table table-hover usergrouptables"><thead>'+
  						 '<tr><th>Group Name</th><th>Group Description</th><th>Group Admins</th><th>Total Users</th><th>Request Access</th></tr></thead>'+
  						 '<tbody>'+
  						 '<tr><td>Test Group1</td><td>This is a group for testing purpose only.</td><td>john@example.com</td><td>18</td><td><a href="#"><span class="glyphicon glyphicon-plus"></span></a></td></tr>'+
  						 '<tr><td>Test Group2</td><td>This is a group for testing purpose only no 2.</td><td>john@example.com, mukul@mukul.com</td><td>18</td><td><a href="#"><span class="glyphicon glyphicon-plus"></span></a></td></tr>'+
  						 '<tr><td>Test Group3</td><td>This is a group for testing purpose only no 3.</td><td>john@example.com, mukul@mukul.com, kanwal@kanwal.com</td><td>18</td><td><a href="#"><span class="glyphicon glyphicon-plus"></span></a></td></tr>'+
  						 '</tbody></table>';

var tablegroupscontent = '<table class="table table-hover usergrouptables"><thead>'+
	 '<tr><th>Group Name</th><th>Group Description</th><th>Group Admins</th><th>Total Users</th><th>Request Access</th></tr></thead>'+
	 '<tbody>'+
	 'REPLACEWITHTABLEBODY'+
	 '</tbody></table>';

var tablerowgroupsContent = '<tr><td><a href="javascript:void[0]" onclick="showgroupdetails(\'REPLACEGROUPID\')">REPLACEGROUPNAME</td><td>REPLACEGROUPDESCRIPTION</td><td>REPLACEGROUPADMIN</td><td>REPLACETOTALMEMBERS</td><td><a href="javascript:void[o]" onclick="requestUserAccessToGroup(\'REPLACEGROUPID\')"><span class="glyphicon glyphicon-plus"></span></a></td></tr>'


function showmygroups(){
	//class action
	$("#usergroupactionform").html('');
	$("#mygroupoption").removeClass("selected");
	$("#allgroupoption").removeClass("selected");
	$("#grouprequestoption").removeClass("selected");
	$("#groupdetails").removeClass("selected");
	$("#mygroupoption").addClass("selected");
	//
	
	$("#usergroupactionitems").hide();
	$("#usergroupactionitems").show();
	$("#addnewgroup").hide();
	$("#addnewmember").hide();
	$("#addnewgroup").show();
	$("#usergroupscontent").html('');
	
	var emailId = $("#loggedInUserIdVar").val();
	
	$.ajax( {
		type : 'POST',
		url : '/'+acunnocontext+'/fetchmyusergroups',
		data: { 
		       'emailId': emailId
		},
	    success : function(response) {
	      	var allresponses = eval('(' + response + ')');
	      	var tableContentUpdated = tablegroupscontent; 
			if (allresponses) {
				if(allresponses.status='success'){
					if(allresponses.usergroups){
						var usergroupsarray = allresponses.usergroups;
						var allrowscontent = '';
						for(var i=0;i<usergroupsarray.length;i++){
							newtablerowgroupsContent = tablerowgroupsContent; 
							
							newtablerowgroupsContent = newtablerowgroupsContent.split('REPLACEGROUPNAME').join(usergroupsarray[i].groupName);
							newtablerowgroupsContent = newtablerowgroupsContent.split('REPLACEGROUPDESCRIPTION').join(usergroupsarray[i].groupDescription);
							newtablerowgroupsContent = newtablerowgroupsContent.split('REPLACEGROUPADMIN').join(usergroupsarray[i].superAdminEmailId);
							newtablerowgroupsContent = newtablerowgroupsContent.split('REPLACETOTALMEMBERS').join('100');
							newtablerowgroupsContent = newtablerowgroupsContent.split('REPLACEGROUPID').join(usergroupsarray[i].groupId);
							allrowscontent = allrowscontent+newtablerowgroupsContent;
						}
						tableContentUpdated = tableContentUpdated.split('REPLACEWITHTABLEBODY').join(allrowscontent);
					}
				}else{
					alert("Adding group failed, please try after some time.");
					tableContentUpdated = tableContentUpdated.split('REPLACEWITHTABLEBODY').join('');
					
					}
				$("#usergroupscontent").html(tableContentUpdated);
				}
	    },
	    failure:function(response){
	    	
	    }
	});

	
	
	$("#usergroupscontent").html(tablegroupscontent);
}

function showallgroups(){
	//class action
	$("#usergroupactionform").html('');
	$("#mygroupoption").removeClass("selected");
	$("#allgroupoption").removeClass("selected");
	$("#grouprequestoption").removeClass("selected");
	$("#groupdetails").removeClass("selected");
	$("#allgroupoption").addClass("selected");
	//
	
	$("#addnewgroup").hide();
	$("#addnewmember").hide();
	$("#usergroupactionitems").hide();
	$("#usergroupscontent").html('');
	
	var emailId = $("#loggedInUserIdVar").val();
	
	$.ajax( {
		type : 'POST',
		url : '/'+acunnocontext+'/fetchallusergroups',
		data: { 
		       'emailId': 'All'
		},
	    success : function(response) {
	      	var allresponses = eval('(' + response + ')');
	      	var tableContentUpdated = tablegroupscontent; 
			if (allresponses) {
				if(allresponses.status='success'){
					if(allresponses.usergroups){
						var usergroupsarray = allresponses.usergroups;
						var allrowscontent = '';
						for(var i=0;i<usergroupsarray.length;i++){
							newtablerowgroupsContent = tablerowgroupsContent; 
							
							newtablerowgroupsContent = newtablerowgroupsContent.split('REPLACEGROUPNAME').join(usergroupsarray[i].groupName);
							newtablerowgroupsContent = newtablerowgroupsContent.split('REPLACEGROUPDESCRIPTION').join(usergroupsarray[i].groupDescription);
							newtablerowgroupsContent = newtablerowgroupsContent.split('REPLACEGROUPADMIN').join(usergroupsarray[i].superAdminEmailId);
							newtablerowgroupsContent = newtablerowgroupsContent.split('REPLACETOTALMEMBERS').join('100');
							newtablerowgroupsContent = newtablerowgroupsContent.split('REPLACEGROUPID').join(usergroupsarray[i].groupId);
							allrowscontent = allrowscontent+newtablerowgroupsContent;
						}
						tableContentUpdated = tableContentUpdated.split('REPLACEWITHTABLEBODY').join(allrowscontent);
					}
				}else{
					alert("Adding group failed, please try after some time.");
					tableContentUpdated = tableContentUpdated.split('REPLACEWITHTABLEBODY').join('');
					
					}
				$("#usergroupscontent").html(tableContentUpdated);
				}
	    },
	    failure:function(response){
	    }
	});
	$("#usergroupscontent").html(tablegroupscontent);
}

function showgrouprequests(){
	
	//class action
	$("#usergroupactionform").html('');
	$("#mygroupoption").removeClass("selected");
	$("#allgroupoption").removeClass("selected");
	$("#grouprequestoption").removeClass("selected");
	$("#groupdetails").removeClass("selected");
	$("#grouprequestoption").addClass("selected");
	//
	
	$("#addnewgroup").hide();
	$("#addnewmember").hide();
	$("#usergroupactionitems").hide();
	$("#usergroupscontent").html('');
	$("#usergroupscontent").html(tablegroupscontent);
}

var addnewgroupform = '<span id="addnewmessagegroup" class="addnewmessagegroupcls"><div class="form-group"><label for="usr">Group Name:</label><input type="text" class="form-control" id="inputgroupname"></div>'+
					 '<div class="form-group"><label for="comment">Group Description:</label><textarea class="form-control" rows="5" id="inputgroupdescription"></textarea>'+
					 '<button type="button" class="btn btn-primary addnewgroupbutton" onclick="addnewusergroup()">Add</button>'+'</div></span>';

function displayaddnewgroupform(){
	$("#usergroupactionform").html('');
	$("#usergroupactionform").html(addnewgroupform);
}


function addnewusergroup(){
	var inputgroupname = $("#inputgroupname").val();
	var groupdescription = $("#inputgroupdescription").val();
	var emailId = $("#loggedInUserIdVar").val();
	
	$.ajax( {
		type : 'POST',
		url : '/'+acunnocontext+'/addnewusergroup',
		data: { 
		       'groupName': inputgroupname, 
		       'superAdminEmailId': emailId,
		       'groupDescription': groupdescription
		},
	    success : function(response) {
	      	var allresponses = eval('(' + response + ')');
			if (allresponses) {
				if(allresponses.status='success'){
					alert("Add successFully");
				}else{
					alert("Adding group failed, please try after some time.");
					}
				}
	    	showmygroups();
	    },
	    failure:function(response){
	    	
	    }
	});

}

var tablegroupsdetailscontentdummy = '<input type="hidden" name="groupidname" id="groupidselectedfield" value="REPLACEWITHGROUPID"><table class="table table-hover usergrouptables" id="usergroupdetailstable"><thead>'+
	 '<tr><th>User Name</th><th>UserId</th><th>IsAdmin</th><th>AddedOn</th><th>AddedBy</th><th>MakeAdmin</th></tr></thead>'+
	 '<tbody>'+
	 '<tr><td>Mukul Raizada</td><td>mukul.raizada@gmail.com</td><td>Y</td><td>10-12-2008</td><td>mukul.raizada@gmail.com</td><td><a href="#"><span class="glyphicon glyphicon-remove-sign"></span></a></td></tr>'+
	 '<tr><td>Kanwal Bhatia</td><td>bhatia.kanwal@gmail.com</td><td>Y</td><td>10-12-2008</td><td>mukul.raizada@gmail.com</td><td><a href="#"><span class="glyphicon glyphicon-ok-sign"></span></a></td></tr>'+
	 '<tr><td>Vineet Joshi</td><td>joshi.vineet@gmail.com</td><td>Y</td><td>10-12-2008</td><td>mukul.raizada@gmail.com</td><td><a href="#"><span class="glyphicon glyphicon-ok-sign"></span></a></td></tr>'+
	 '</tbody></table>';


function showgroupdetails(groupid){
	//class action
	$("#usergroupactionform").html('');
	$("#mygroupoption").removeClass("selected");
	$("#allgroupoption").removeClass("selected");
	$("#grouprequestoption").removeClass("selected");
	$("#groupdetails").removeClass("selected");
	$("#groupdetails").addClass("selected");
	//
	
	$("#addnewgroup").hide();
	$("#addnewmember").show();
	$("#usergroupactionitems").show();
	$("#usergroupscontent").html('');
	$("#groupidselectedfield").val(groupid);
	$("#usergroupscontent").html(tablegroupsdetailscontentdummy);
	
}

var addnewuserform = '<span id="addnewuserform" class="addnewmessagegroupcls">'+
'<div class="form-group"><label for="usr">Added User:</label><input type="text" class="form-control" id="addedusername" readonly>'+
'<div class="form-group"><label for="usr">Search UserId/User Name:</label><input type="text" onkeyup="lookupuserreference()" class="form-control" id="inputusername"><span class="userlookupareaclass" id="userlookuparea"></span></div>'+
'<div class="form-group"><label for="usr">EmailId:</label><input type="text" class="form-control" id="inputuseremailid" readonly><label for="usr">FirstName:</label><input type="text" class="form-control" id="inputuserfirstname" readonly><label for="usr">LastName:</label><input type="text" class="form-control" id="inputuserlastname" readonly>'+
'<button type="button" class="btn btn-primary addnewgroupbutton" onclick="addnewusertogroupui()">Add</button><button type="button" class="btn btn-primary addnewgroupbutton" onclick="addnewusergroup()">Update Group</button>'+'</div></span>';

var userlookupitem =  '<li onclick="selectUserToGroup(\'REPLACEEMAILID\',\'REPLACELASTNAME\',\'REPLACEFIRSTNAME\');"><a href="javascript:void(0)">REPLACELASTNAME, REPLACEFIRSTNAME (REPLACEEMAILID)</a></li>';

function lookupuserreference(){
	
	var inputusername = $("#inputusername").val();
	var emailId = $("#loggedInUserIdVar").val();
	
	$.ajax( {
		type : 'POST',
		url : '/'+acunnocontext+'/searchactiveusers',
		data: { 
		       'searchString': inputusername, 
		       'emailId': emailId
		},
	    success : function(response) {
	      	var allresponses = eval('(' + response + ')');
			if (allresponses) {
				searchComponent = '<ul>';
				if(allresponses.status='success'){
					
					if(allresponses.usersarray){
						var searchedUsersData = '';
						for(var i=0; i<allresponses.usersarray.length;i++){
							var searcheduserrow = userlookupitem;
							searcheduserrow = searcheduserrow.split('REPLACEEMAILID').join(allresponses.usersarray[i].emailId);
							searcheduserrow = searcheduserrow.split('REPLACELASTNAME').join(allresponses.usersarray[i].lastName);
							searcheduserrow = searcheduserrow.split('REPLACEFIRSTNAME').join(allresponses.usersarray[i].firstName);
							searchedUsersData = searchedUsersData + searcheduserrow; 
						}	
						searchComponent = searchComponent+searchedUsersData; 
					}
					else{
						searchComponent = searchComponent+'<li>NO VALID USER</li>';
						}
				}else{
					searchComponent = searchComponent+'<li>NO VALID USER</li>';
					}
				searchComponent = searchComponent+'</ul>';
				$("#userlookuparea").html(searchComponent)
				}
	    },
	    failure:function(response){
	    	
	    }
	});

}


function selectUserToGroup(emailId, lastName, firstName){
		$("#inputuserfirstname").val(firstName);
		$("#inputuseremailid").val(lastName);
		$("#inputuserlastname").val(emailId);
		$("#userlookuparea").html('')
	}

function addnewusertogroupui(){
	var selectedEmailId = $("#inputuserlastname").val();
	var addedUser = $("#addedusername").val();
	$("#addedusername").val(addedUser+","+selectedEmailId);
}

function addnewusertogroup(){
	var addedUser = $("#addedusername").val();
	var emailId = $("#loggedInUserIdVar").val();
	var groupId = $("#groupidselectedfield").val();
	
	$.ajax( {
		type : 'POST',
		url : '/'+acunnocontext+'/adduserstogroup',
		data: { 
		       'searchString': addedUser,
		       'emailId':emailId,
		       'groupId':groupId
		},
	    success : function(response) {
	      	var allresponses = eval('(' + response + ')');
			if (allresponses) {
				searchComponent = '<ul>';
				if(allresponses.status='success'){
					
					if(allresponses.usersarray){
						var searchedUsersData = '';
						for(var i=0; i<allresponses.usersarray.length;i++){
							var searcheduserrow = userlookupitem;
							searcheduserrow = searcheduserrow.split('REPLACEEMAILID').join(allresponses.usersarray[i].emailId);
							searcheduserrow = searcheduserrow.split('REPLACELASTNAME').join(allresponses.usersarray[i].lastName);
							searcheduserrow = searcheduserrow.split('REPLACEFIRSTNAME').join(allresponses.usersarray[i].firstName);
							searchedUsersData = searchedUsersData + searcheduserrow; 
						}	
						searchComponent = searchComponent+searchedUsersData; 
					}
					else{
						searchComponent = searchComponent+'<li>NO VALID USER</li>';
						}
				}else{
					searchComponent = searchComponent+'<li>NO VALID USER</li>';
					}
				searchComponent = searchComponent+'</ul>';
				$("#userlookuparea").html(searchComponent)
				}
	    },
	    failure:function(response){
	    	
	    }
	});
	
}


function displayaddnewuserform(){
$("#usergroupactionform").html('');
$("#usergroupactionform").html(addnewuserform);
}