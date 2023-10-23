const hre = require('hardhat')
const main = async () =>{
  const Transactions = await hre.ethers.deployContract("Transactions");

  await Transactions.waitForDeployment();
  console.log("Transactions deployed to " + Transactions.target);
} 

const runMain = async ()=>{
  try {
    await main();
    process.exit(0);
  } catch (error) {
    console.error(error);
    process.exit(1);
  }
}


runMain();