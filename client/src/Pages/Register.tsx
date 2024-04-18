import React, { useState } from 'react';
import { AuthenticationApi, RegisterRequest } from '../openapi';
import { useNavigate } from 'react-router-dom';

interface RegisterFormState {
    firstName: string;
    lastName: string;
    email: string;
    password: string;
}

const Register = () => {
    const [formData, setFormData] = useState<RegisterFormState>({
        firstName: '',
        lastName: '',
        email: '',
        password: ''
    });
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState('');

    const navigate = useNavigate();

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const handleRegister = async (e: React.FormEvent) => {
        e.preventDefault();
        setLoading(true);
        setError('');

        const api = new AuthenticationApi();
        const requestParams: RegisterRequest = {
            registrationRequest: {
                firstName: formData.firstName,
                lastName: formData.lastName,
                email: formData.email,
                password: formData.password
            },
        };

        try {
            await api.register(requestParams);
            navigate('/accountActivate');
        } catch (error: any) {
            console.error("Registration Error:", error);
            setError("Failed to register. Please try again.");
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="flex items-center justify-center h-screen bg-gray-100">
            <div className="bg-white p-8 rounded-lg shadow-lg max-w-md w-full">
                <h2 className="text-2xl font-bold text-center mb-6">Register</h2>
                {error && <p className="text-red-500">{error}</p>}
                <form className="space-y-4" onSubmit={handleRegister}>
                    <input type="text" name="firstName" value={formData.firstName} onChange={handleChange} placeholder="First Name" className="w-full p-2 border border-gray-300 rounded" required />
                    <input type="text" name="lastName" value={formData.lastName} onChange={handleChange} placeholder="Last Name" className="w-full p-2 border border-gray-300 rounded" required />
                    <input type="email" name="email" value={formData.email} onChange={handleChange} placeholder="Email" className="w-full p-2 border border-gray-300 rounded" required />
                    <input type="password" name="password" value={formData.password} onChange={handleChange} placeholder="Password" className="w-full p-2 border border-gray-300 rounded" required />
                    <button type="submit" className="w-full bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" disabled={loading}>
                        {loading ? 'Registering...' : 'Register'}
                    </button>
                </form>
            </div>
        </div>
    );
}

export default Register;
