import { Navigate, Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
import Error from "./pages/Error";
import MainLayout from "./pages/layouts/MainLayout";
import UserList from "./pages/user/UserList";

function App() {
  return (
    <Routes>
      <Route path="/" element={<MainLayout />} >
        <Route path="/" element={<Navigate replace to="/home" />}></Route>
        <Route path="/home" element={<Home />}></Route>
        <Route path="/user/list" element={<UserList/>}></Route>
      </Route>
      <Route path="*" element={<Error />} />
    </Routes>
  );
}

export default App;
