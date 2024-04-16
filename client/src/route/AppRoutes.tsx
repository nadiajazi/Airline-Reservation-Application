import React from "react";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import Register from "../Pages/Register";

const AppRoutes: React.FC = ()  => {
    return(
        <Router>
            <Routes>
                <Route path="/" element={<Register />} />
            </Routes>
        </Router>
    )

}
export default AppRoutes;