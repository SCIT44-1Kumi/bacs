export default function KioskCategorybar() {
  return <nav className="relative flex flex-wrap items-center justify-between px-2 py-3 navbar-expand-lg bg-teal-500 mb-3 rounded-t-lg">
    <div className="container px-4 mx-auto flex flex-wrap items-center justify-center">
      {/*<div className="w-full relative flex justify-between lg:w-auto  px-4 lg:static lg:block lg:justify-start">*/}
      {/*  <a className="text-sm font-bold leading-relaxed inline-block mr-4 py-2 whitespace-no-wrap uppercase text-white" href="#pablo">*/}
      {/*    teal Color*/}
      {/*  </a>*/}
      {/*  <button className="cursor-pointer text-xl leading-none px-3 py-1 border border-solid border-transparent rounded bg-transparent block lg:hidden outline-none focus:outline-none" type="button">*/}
      {/*    <span className="block relative w-6 h-px rounded-sm bg-white"></span>*/}
      {/*    <span className="block relative w-6 h-px rounded-sm bg-white mt-1"></span>*/}
      {/*    <span className="block relative w-6 h-px rounded-sm bg-white mt-1"></span>*/}
      {/*  </button>*/}
      {/*</div>*/}
      <div className="flex items-center w-full">
        <ul className="flex list-none justify-evenly flex-1 flex-wrap w-full">
          <li className="nav-item">
            <a className="px-3 py-2 flex items-center text-xs uppercase font-bold leading-snug text-white hover:opacity-75" href="#pablo">
              커피
            </a>
          </li>
          <li className="nav-item">
            <a className="px-3 py-2 flex items-center text-xs uppercase font-bold leading-snug text-white hover:opacity-75" href="#pablo">
              프라푸치노
            </a>
          </li>
          <li className="nav-item">
            <a className="px-3 py-2 flex items-center text-xs uppercase font-bold leading-snug text-white hover:opacity-75" href="#pablo">
              디저트
            </a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
}