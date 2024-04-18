import React, { useState, useRef } from 'react';
import { AuthenticationApi } from '../openapi';
import {useNavigate} from "react-router-dom";

const ActivateAccount: React.FC = () => {
    const [code, setCode] = useState(Array(6).fill(''));
    const [message, setMessage] = useState<string>('');
    const [error, setError] = useState<string>('');
    const [isLoading, setIsLoading] = useState<boolean>(false);

    const inputRefs = useRef<HTMLInputElement[]>([]);

    const handleInput = (value: string, index: number) => {
        const newCode = [...code];
        newCode[index] = value;
        setCode(newCode);

        if (value && index < 5) {
            inputRefs.current[index + 1].focus();
        }
    };

    const handleBackspace = (e: React.KeyboardEvent<HTMLInputElement>, index: number) => {
        if (e.key === 'Backspace' && !code[index]) {
            if (index > 0) {
                inputRefs.current[index - 1].focus();
            }
        }
    };

    const navigate = useNavigate();
    const handleActivateAccount = async () => {
        const activationCode = code.join('');
        if (activationCode.length !== 6) {
            setError('The code must be exactly 6 digits.');
            return;
        }

        const api = new AuthenticationApi();
        setIsLoading(true);
        try {
            await api.confirm({ token: activationCode });
            setMessage('Your account has been successfully activated. You may now log in.');
            setError('');
            navigate("/login");
        } catch (err) {
            setMessage('');
            setError('Failed to activate account. The code may be invalid or expired.');
            console.error('Activation error:', err);
        } finally {
            setIsLoading(false);
        }
    };

    return (
        <div className="flex flex-col items-center justify-center min-h-screen bg-gray-100 p-4">
            <div className="w-full max-w-md bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4">
                <h1 className="block w-full text-center text-gray-800 text-xl font-bold mb-6">Enter Activation Code</h1>
                {message && <p className="text-green-500">{message}</p>}
                {error && <p className="text-red-500">{error}</p>}
                <div className="flex space-x-2 justify-center">
                    {code.map((digit, index) => (
                        <input
                            key={index}
                            type="password"
                            maxLength={1}
                            value={digit}
                            onChange={e => handleInput(e.target.value, index)}
                            onKeyDown={e => handleBackspace(e, index)}
                            ref={el => inputRefs.current[index] = el!}
                            className="w-10 h-10 text-center text-xl bg-gray-200 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
                        />
                    ))}
                </div>
                <button
                    onClick={handleActivateAccount}
                    disabled={isLoading || code.some(char => !char)}
                    className={`mt-4 w-full bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline ${isLoading ? 'opacity-50 cursor-not-allowed' : ''}`}
                >
                    {isLoading ? 'Activating...' : 'Activate Account'}
                </button>
            </div>
        </div>
    );
};

export default ActivateAccount;
