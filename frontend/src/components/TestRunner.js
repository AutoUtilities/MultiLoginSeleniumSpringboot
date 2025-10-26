import React, { useState } from "react";

function TestRunner() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [platform, setPlatform] = useState("facebook");
  const [message, setMessage] = useState("");

  const handleRun = async () => {
    if (!username || !password) {
      setMessage("Please fill all fields.");
      return;
    }

    const url = `http://localhost:8080/api/test/${platform}`;

    const payload = {
      Username: username,
      Password: password,
    };

    try {
      const response = await fetch(url, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(payload),
      });

      if (response.ok) {
        const data = await response.text();
        setMessage(`✅ Test started successfully for ${platform}: ${data}`);
      } else {
        setMessage(`❌ Error: ${response.statusText}`);
      }
    } catch (error) {
      setMessage(`⚠️ Error: ${error.message}`);
    }
  };

  return (
    <div style={{ maxWidth: "400px", margin: "auto", padding: "20px" }}>
      <h2>Run Social Media Test</h2>
      <input
        type="text"
        placeholder="Username"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
        style={{ width: "100%", marginBottom: "10px" }}
      />
      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
        style={{ width: "100%", marginBottom: "10px" }}
      />
      <select
        value={platform}
        onChange={(e) => setPlatform(e.target.value)}
        style={{ width: "100%", marginBottom: "10px" }}
      >
        <option value="facebook">Facebook</option>
        <option value="instagram">Instagram</option>
      </select>
      <button onClick={handleRun} style={{ width: "100%" }}>
        Run Test
      </button>

      {message && <p style={{ marginTop: "15px" }}>{message}</p>}
    </div>
  );
}

export default TestRunner;
