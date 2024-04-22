import Shell from "../shell/Shell";

export default function MainContent({openTerminal}) {
    return (
        <div className="relative h-screen w-full flex flex-col">
            <iframe className="w-full flex-grow" src="http://dataplatform.jupyterhub.io" title="shell"/>
            {openTerminal && <Shell />}
        </div>
    )
}