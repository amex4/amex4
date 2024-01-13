import { Link } from 'react-router-dom';
import './App.css';

function App() {
  return (
    <ul >
      <li >
        <Link to='register'>Register</Link>
      </li>
      <li >
        <Link to='login'>Login</Link>
      </li>
    </ul>
  )
}

export default App;
