var loginDone='<div class="alert alert-success small-warning " role="alert"> <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> You have successfully logged in</div>';
var loginError='<div class="alert alert-danger small-warning " role="alert"> <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> <strong>Error!</strong>Incorrect email or password</div>';


var RegDone='<div class="alert alert-success small-warning " role="alert"> <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> You have successfully registration</div>';
var RegErrorPassword='<div class="alert alert-danger small-warning " role="alert"> <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> <strong>Error!</strong>Password must be minimum of 6 characters</div>';
var RegErrorPasswordConf='<div class="alert alert-danger small-warning " role="alert"> <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> <strong>Error!</strong>Passwords do not match</div>';
var UserNotFound='<div class="alert alert-danger small-warning " role="alert"> <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> <strong>Error!</strong>A user with this nickname is not found</div>';
var EmailAllreadyReg='<div class="alert alert-danger small-warning " role="alert"> <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> <strong>Error!</strong>Email already registered</div>';
var UnknowRegError='<div class="alert alert-danger small-warning " role="alert"> <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> <strong>Error!</strong>Unknown error , please try again later</div>';
window.onbeforeunload = function (evt) {
alert(evt);
}

$('document').ready(function()
{
    $('#login_form').validator().on('submit', function (e) {
        if (e.isDefaultPrevented()) {
            // handle the invalid form...
        } else {
            submitLoginForm();
            return false;
        }
    })

    $('#reg_form').validator().on('submit', function (e) {
        if (e.isDefaultPrevented()) {
            // handle the invalid form...
        } else {
            submitRegForm();
            return false;
        }
    })

    $('#regModal').on('show.bs.modal', function() {
        document.getElementById('zilean').style.zIndex=1045;
        document.getElementById('zilean').style.position='fixed';
        document.getElementById('zilean').style.backgroundSize='300px';
    })

    $('#loginModal').on('show.bs.modal', function() {
        document.getElementById('zilean').style.zIndex=1045;
        document.getElementById('zilean').style.position='fixed';
        document.getElementById('zilean').style.backgroundSize='300px';
    })

    $('#regModal').on('hide.bs.modal', function() {
        document.getElementById('zilean').style.zIndex=10;
        document.getElementById('zilean').style.position='absolute';
        document.getElementById('zilean').style.backgroundSize='0px';
    })

    $('#loginModal').on('hide.bs.modal', function() {
        document.getElementById('zilean').style.zIndex=10;
        document.getElementById('zilean').style.position='absolute';
        document.getElementById('zilean').style.backgroundSize='0px';
    })
})

function submitRegForm()
{
    var data = $("#reg_form").serialize();

    $.ajax({

        type : 'GET',
        url  : '/reg',
        cache: false,
        data : data,
        /*beforeSend: function()
         {
         $("#error").fadeOut();
         $("#btn-login").html('<span class="glyphicon glyphicon-transfer"></span> &nbsp; sending ...');
         },*/
        success :  function(data, status)
        {
            if(data=="1"){

                $(".error_reg").html(RegDone);
                setTimeout(' window.location.href = "/"; ',4000);
            }
            else{
                if(data=="-1") {
                    $(".error_reg").html(RegErrorPassword);
                }else if(data=="-2") {
                    $(".error_reg").html(RegErrorPasswordConf);
                }else if(data=="-3") {
                    $(".error_reg").html(UserNotFound);
                }else if(data=="-4") {
                    $(".error_reg").html(EmailAllreadyReg);
                }else {
                    $(".error_reg").html(UnknowRegError);
                }
            }
        }
    });
    return false;
}

function submitLoginForm()
{
    var data = $("#login_form").serialize();

    $.ajax({

        type : 'GET',
        url  : '/login',
        cache: false,
        data : data,
        success :  function(data, status)
        {
            if(data=="1"){

                $(".error").html(loginDone);
                setTimeout(' window.location.href = "/"; ',4000);
            }
            else{

                $(".error").html(loginError);
            }
        }
    });
    return false;
}


function openPage(formMain,url) {

    jQuery.ajax({
        url: url,
        type: "GET",
        dataType: "html",
        success: function(response) {
            var obj = JSON.parse(response);
            document.getElementById("user_form").innerHTML = obj.login;
            document.getElementById("wrapper").innerHTML = obj.body;
            Holder.run();

        },
        error: function(response) {
            document.getElementById("wrapper").innerHTML = "Emmm... something wrong O_o";
        }
    });

    window.history.pushState( {} , null, formMain );
    return false;
}
