const TOKEN_KEY = 'authToken';

export const tokenService = {

    setToken: (token: string ): void => {
        localStorage.setItem(TOKEN_KEY, token);
    },


    getToken: (): string | null => {
        return localStorage.getItem(TOKEN_KEY);
    },
    isTokenValid: (): boolean => {
        const token = localStorage.getItem(TOKEN_KEY);
        if (!token) return false;

        const { exp } = JSON.parse(atob(token.split('.')[1]));
        const isExpired = Date.now() >= exp * 1000;

        if (isExpired) {
            localStorage.removeItem(TOKEN_KEY);
            return false;
        }

        return true;
    },


    clearToken: (): void => {
        localStorage.removeItem(TOKEN_KEY);
    }
};
