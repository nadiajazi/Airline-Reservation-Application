import React from "react";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import Register from "../Pages/Register";
import Login from "../Pages/Login";

const AppRoutes: React.FC = ()  => {
    return(
        <Router>
            <Routes>
                <Route path="/" element={<Register />} />
                <Route path="/login" element={<Login />} />
            </Routes>
        </Router>
    )

}
export default AppRoutes;