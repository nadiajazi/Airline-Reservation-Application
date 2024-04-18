const TOKEN_KEY = 'authToken';

export const tokenService = {

    setToken: (token: string ): void => {
        localStorage.setItem(TOKEN_KEY, token);
    },


    getToken: (): string | null => {
        return localStorage.getItem(TOKEN_KEY);
    },


    clearToken: (): void => {
        localStorage.removeItem(TOKEN_KEY);
    }
};
