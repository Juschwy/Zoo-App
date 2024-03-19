import {useState} from 'react'
import './App.css'
import ZooHeader from "./components/ZooHeader";

function App() {
    const [count, setCount] = useState(0)

    return (
        <>
            <header>
                <a href={"/aboutus"}>About Us</a>
                <ZooHeader/>
            </header>



            <h1>Zoo App</h1>
            <div className="card">
                <button onClick={() => setCount((count) => count + 1)}>
                    count is {count}
                </button>
                <p>
                    Edit <code>src/App.tsx</code> and save to test HMR
                </p>
            </div>
            <footer>
                Click on the Vite and React logos to learn more
            </footer>
        </>
    );
}

export default App;
