import Home from "./pages/Home.svelte";
import Freelancers from "./pages/Freelancers.svelte";
import Jobs from "./pages/Jobs.svelte";
import Bestellung from "./pages/Bestellung.svelte";
import BestellungGericht from "./pages/BestellungGericht.svelte";
import Gericht from "./pages/Gericht.svelte";
import Kunden from "./pages/Kunden.svelte";
import Lieferanten from "./pages/Lieferanten.svelte";

export default {
    '/': Home,
    '/home': Home,
    '/freelancers': Freelancers,
    '/bestellung': Bestellung,
    '/bestellungGericht': BestellungGericht,
    '/gericht': Gericht,
    '/kunden': Kunden,
    '/lieferanten': Lieferanten,
    '/jobs': Jobs
}