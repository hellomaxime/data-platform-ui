import Shell from "../shell/Shell";
import RouteService from "./RouteService";

export default function MainContent({openTerminal, openService}) {
    return (
        <div className="relative h-screen w-full flex flex-col">
            <RouteService openService={openService} />
            {openTerminal && <Shell />}
        </div>
    )
}