import React from "react";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import Register from "../Pages/Register";
import Login from "../Pages/Login";
import HomePage from "../Pages/HomePage";
import AccountActivate from "../Pages/AccountActivate";

const AppRoutes: React.FC = ()  => {
    return(
        <Router>
            <Routes>
                <Route path="/" element={<Register />} />
                <Route path="/login" element={<Login />} />
                <Route path="/homePage" element={<HomePage />}/>
                <Route path="/accountActivate" element={<AccountActivate />}/>
            </Routes>
        </Router>
    )

}
export default AppRoutes;