import React from 'react';
import './App.css';

function App() {
  return (
      <div className="max-w-md mx-auto bg-white rounded-xl shadow-md overflow-hidden md:max-w-2xl">
        <div className="md:flex">
          <div className="p-8">
            <div className="uppercase tracking-wide text-sm text-indigo-500 font-semibold">Welcome to React with Tailwind</div>
            <a href="#" className="block mt-1 text-lg leading-tight font-medium text-black hover:underline">Using Tailwind CSS with React</a>
            <p className="mt-2 text-gray-500">Quickly build an efficient and aesthetically pleasing user interface.</p>
          </div>
        </div>
      </div>
  );
}

export default App;
