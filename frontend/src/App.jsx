import { useState } from "react"
import SidebarMenu from "./components/sidebar-menu/SidebarMenu";
import MainContent from "./components/main-content/MainContent";

function App() {

  const [openTerminal, setOpenTerminal] = useState(false);
  const [openService, setOpenService] = useState("home");

  return (
    <div className="flex justify-between">
      <SidebarMenu openTerminal={openTerminal} setOpenTerminal={setOpenTerminal} setOpenService={setOpenService}/>
      <MainContent openTerminal={openTerminal} openService={openService}/>
    </div>
  )
}

export default App