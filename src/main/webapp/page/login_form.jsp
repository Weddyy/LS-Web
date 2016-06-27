<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content modal-sm-login login_wrapper">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Login</h4>
            </div>
            <div class="modal-body small_wnd">
                <div class="error">
                </div>
                <form class="form-horizontal" id="login_form" method="post" novalidate="novalidate" role="form" data-toggle="validator">
                    <div class="form-group">
                        <div class="input-group"> <span class="input-group-addon">@</span>
                            <input class="form-control" placeholder="Email" name="email" id="inputEmail" type="email" maxlength="30" data-error="That email address is invalid" required>
                        </div>
                        <div class="help-block with-errors"></div>
                    </div>

                    <div class="form-group">
                        <div class="input-group"> <span class="input-group-addon"> <i class="glyphicon glyphicon-lock"></i> </span>
                            <input class="form-control" placeholder="Password" name="password" type="password" value="" data-minlength="6" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-0 col-sm-10">
                            <div class="checkbox">
                                <label class="remember">
                                    <input type="checkbox"> Remember me
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-0 col-sm-12">
                            <button type="submit" id="sign" class="btn btn-block button_nm">Sign in</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <a>Forgotten password</a>
            </div>
        </div>
    </div>
</div>