<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

    <body>


        <div>
            <h1>Strava Teams</h1>
            <p>Strava Teams is application that allows you to create team runs and manage run leaderboards</p>
        </div>
        <div>

            <p>
                <a href="${strava_url}?client_id=${client_id}&response_type=code&redirect_uri=http://${host}/token&approval_prompt=force&state=login&scope=view_private">
                    Login To Strava
                </a>
            </p>

        </div>

    </body>

</html>