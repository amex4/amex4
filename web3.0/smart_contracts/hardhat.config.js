require("@nomicfoundation/hardhat-toolbox");

/** @type import('hardhat/config').HardhatUserConfig */
module.exports = {
  solidity: "0.8.19",
 networks:{
  Sepolia : {
    url : "https://eth-sepolia.g.alchemy.com/v2/g03WJqLdzUyJIrP4flJdmrpMZdj8DNXv",
    accounts :['47e8df63b932e99fcd08a3169dac82b29d0fd853847f3d77fafab027427a7639']
  }
 }
};
