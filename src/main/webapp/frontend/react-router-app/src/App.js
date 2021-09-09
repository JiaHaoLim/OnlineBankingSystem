import './App.css';
import './index.css';
import {Route, Switch} from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import HomePage from './pages/HomePage';

function App() {
  return (
    <Switch>
        <Route exact path="/" component={LoginPage}/>
        <Route path="/home" component={HomePage}/>
    </Switch>
  );
}

export default App;
