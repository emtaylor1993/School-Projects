library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity VendingMachine is
    Port (clk : in  STD_LOGIC;
		reset : in  STD_LOGIC;
		coin : in  STD_LOGIC_VECTOR (2 downto 0);
		select : in  STD_LOGIC_VECTOR (3 downto 0);
		money : out  STD_LOGIC_VECTOR (7 downto 0);
		price : out  STD_LOGIC_VECTOR (7 downto 0);
		product : out  STD_LOGIC_VECTOR (3 downto 0));
end VendingMachine;

architecture Behavioral of VendingMachine is

begin
end Behavioral;

