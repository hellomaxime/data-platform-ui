import { useState } from "react"
import SidebarMenu from "./components/sidebar-menu/sidebar-menu";

function App() {

  // const [open, setOpen] = useState(true);

  return (
    <div className="flex justify-between">
      <SidebarMenu />
      <div className="h-screen w-full">
        <iframe className="h-screen w-full" src="http://dataplatform.jupyterhub.io" title="shell"/>
        {/* {open && <iframe className="absolute bottom-0" src="http://dataplatform.shell.io/wetty" width={"100%"} height={"300px"} title="shell"/>} */}
      </div>
    </div>
  )
}

export default App