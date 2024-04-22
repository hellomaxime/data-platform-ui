import { useState } from "react"
import SidebarMenu from "./components/sidebar-menu/SidebarMenu";
import MainContent from "./components/main-content/MainContent";

function App() {

  const [openTerminal, setOpenTerminal] = useState(false);

  return (
    <div className="flex justify-between">
      <SidebarMenu openTerminal={openTerminal} setOpenTerminal={setOpenTerminal}/>
      <MainContent openTerminal={openTerminal}/>
    </div>
  )
}

export default App