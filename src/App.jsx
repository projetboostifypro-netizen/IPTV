import { useState } from "react";
import { Player } from "./player";

export default function App() {
  const [url, setUrl] = useState("https://test-streams.mux.dev/x36xhzz/x36xhzz.m3u8");
  const [status, setStatus] = useState("");

  const play = async () => {
    try {
      setStatus("Ouverture du lecteur...");
      await Player.open({ url, title: "Test IPTV" });
      setStatus("Lecteur ouvert");
    } catch (e) {
      setStatus("Erreur: " + (e?.message || String(e)));
    }
  };

  return (
    <div style={{ padding: 16, fontFamily: "Arial" }}>
      <h2>IPTV Player (ExoPlayer intégré)</h2>

      <input
        value={url}
        onChange={(e) => setUrl(e.target.value)}
        style={{ width: "100%", padding: 12, borderRadius: 10, border: "1px solid #ddd" }}
        placeholder="Lien m3u8 / mp4 / ts..."
      />

      <button
        onClick={play}
        style={{ marginTop: 10, padding: 12, borderRadius: 10, border: "1px solid #111", background: "#111", color: "white" }}
      >
        Lire dans l’app
      </button>

      {status && <div style={{ marginTop: 10, fontSize: 13 }}>{status}</div>}
    </div>
  );
}
