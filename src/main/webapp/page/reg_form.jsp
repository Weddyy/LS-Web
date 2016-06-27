
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="modal fade" id="regModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content modal-sm-reg login_wrapper">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Registration</h4>
            </div>
            <div class="modal-body">
                <div class="error_reg">
                </div>
                <form class="form-horizontal" novalidate="true" role="form" data-toggle="validator" id="reg_form">
                    <div class="form-group">
                        <div class="col-sm-12 reg_form_label">Email</div>
                        <div class="col-sm-12">
                            <div class="input-group"> <span class="input-group-addon">@</span>
                                <input class="form-control" placeholder="Email" name="email" id="inputEmail" type="email" maxlength="30" data-error="That email address is invalid" required>
                            </div>
                            <div class="help-block with-errors"></div>
                            </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-6 reg_form_label">Password</div>
                        <div class="col-sm-6 reg_form_label">Confirm password</div>
                        <div class="col-sm-6">
                            <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input type="password" class="form-control" placeholder="Password" name="password" data-minlength="6" id="inputPassword" required>
                            </div>
                            <span class="help-block">Minimum of 6 characters</span>
                        </div>


                        <div class="col-sm-6">
                            <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input type="password" class="form-control" placeholder="Confirm" name="repassword" data-minlength="6" data-match="#inputPassword" data-match-error="Confirm password incorrect" required>
                            </div>
                            <span class="help-block">Passwords must match</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-6 reg_form_label">Nick name in League of Legend</div>
                        <div class="col-sm-6 reg_form_label">Select server</div>
                        <div class="col-sm-6">
                            <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="text" class="form-control" name="nick" placeholder="Nick name in League of Legend" data-minlength="2" data-error="That nick name is invalid" required>
                            </div>
                            <div class="help-block with-errors"></div>
                        </div>
                        <div class="col-sm-6">
                            <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-globe"></i></span>
                                <select class="form-control" name="serverId">
                                    <option>NA</option>
                                    <option>EUW</option>
                                    <option>EUNE</option>
                                    <option>KR</option>
                                    <option>OCE</option>
                                    <option>BR</option>
                                    <option>LAN</option>
                                    <option>LAS</option>
                                    <option>RU</option>
                                    <option>TR</option>
                                </select>
                                </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12 reg_form_label">
                            <button type="submit" class="btn btn-block button_nm disabled">Registration</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>