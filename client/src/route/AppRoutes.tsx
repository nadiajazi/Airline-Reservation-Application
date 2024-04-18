import React from "react";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import Register from "../Pages/Register";
import Login from "../Pages/Login";
import HomePage from "../Pages/HomePage";
import AccountActivate from "../Pages/AccountActivate";
import ProtectedRoute from '../services/ProtectedRoute';
import { AuthProvider } from '../services/AuthContext';

const AppRoutes: React.FC = ()  => {
    return(
        <Router>
            <AuthProvider>
            <Routes>
                <Route path="/" element={<Register />} />
                <Route path="/login" element={<Login />} />
                <Route path="/accountActivate" element={<AccountActivate />}/>
                <Route element={<ProtectedRoute redirectTo="/login" />}>
                    <Route path="/homePage" element={<HomePage />} />
                </Route>
            </Routes>
            </AuthProvider>
        </Router>
    )

}
export default AppRoutes;