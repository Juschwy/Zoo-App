import {useState} from 'react'
import './App.css'

function App() {
    const [count, setCount] = useState(0)

    return (
        <>
            <header>
                <a href={"/aboutus"}>About Us</a>
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
            <footer style={{position: "fixed"}}>
                Click on the Vite and React logos to learn more
            </footer>
        </>
    )
}

export default App
